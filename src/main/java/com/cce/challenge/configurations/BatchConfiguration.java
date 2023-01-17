package com.cce.challenge.configurations;

import com.cce.challenge.batch.models.AgenteData;
import com.cce.challenge.listeners.JobCompletionNotificationListener;
import com.cce.challenge.processors.AgentItemProcessor;
import com.cce.challenge.repository.entity.Agente;
import com.cce.challenge.services.AgenteService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.adapter.ItemWriterAdapter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.IOException;

@Configuration
public class BatchConfiguration {

    @Bean
    public MultiResourceItemReader<AgenteData> multiResourceItemReader()
    {
        Resource[] resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("/exemplo_*.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiResourceItemReader<AgenteData> resourceItemReader = new MultiResourceItemReader<AgenteData>();
        resourceItemReader.setResources(resources);
        resourceItemReader.setDelegate(reader());
        return resourceItemReader;
    }

    @Bean
    @StepScope
    public StaxEventItemReader<AgenteData> reader() {
        StaxEventItemReader<AgenteData> xmlFileReader = new StaxEventItemReader<>();
        xmlFileReader.setFragmentRootElementName("agente");

        Jaxb2Marshaller xmlMarshaller = new Jaxb2Marshaller();
        xmlMarshaller.setClassesToBeBound(AgenteData.class);
        xmlFileReader.setUnmarshaller(xmlMarshaller);
        return xmlFileReader;
    }

    @Bean
    public AgentItemProcessor processor() {
        return new AgentItemProcessor();
    }

    @Bean
    public ItemWriterAdapter<Agente> writer(AgenteService agenteService) {
        ItemWriterAdapter<Agente> writer = new ItemWriterAdapter<>();
        writer.setTargetObject(agenteService);
        writer.setTargetMethod("create");
        return writer;
    }



    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }


    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, ItemWriterAdapter<Agente> writer) {
        return new StepBuilder("step1", jobRepository)
                .<AgenteData, Agente> chunk(10, transactionManager)
                .reader(multiResourceItemReader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
