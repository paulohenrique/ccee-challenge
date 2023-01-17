package com.cce.challenge.processors;

import com.cce.challenge.batch.models.AgenteData;
import com.cce.challenge.batch.models.RegiaoData;
import com.cce.challenge.repository.entity.Agente;
import com.cce.challenge.repository.entity.Regiao;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AgentItemProcessor implements ItemProcessor<AgenteData, Agente> {

    @Override
    public Agente process(final AgenteData item) throws Exception {

        /* Ao receber cada arquivo, o back-end deve apenas imprimir na saída padrão
            (System.out) os códigos de agentes */
        System.out.println("Codigo do agente: " + item.getCodigo());

        Agente agente = new Agente();
        agente.setId(item.getId());
        agente.setCodigo(item.getCodigo());
        agente.setData(LocalDateTime.parse(item.getData(), DateTimeFormatter.ISO_ZONED_DATE_TIME));
        agente.setRegiao(buildRegiao(item.getRegiaos()));

        return agente;
    }

    private List<Regiao> buildRegiao(List<RegiaoData> regiaos) {
        return regiaos.stream().map( rd -> buildReg(rd)).collect(Collectors.toList());
    }

    private Regiao buildReg(RegiaoData rd) {
        Regiao regiao = new Regiao();
        regiao.setSigla(rd.getSigla());
        regiao.setGeracao(getReduce(rd.getGeracao()));
        regiao.setCompra(getReduce(rd.getCompra()));

        return regiao;
    }

    private Double getReduce(List<Double> values) {
        return values.stream().reduce(0D, Double::sum);
    }
}
