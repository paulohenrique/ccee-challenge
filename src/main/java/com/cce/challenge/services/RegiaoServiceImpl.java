package com.cce.challenge.services;

import com.cce.challenge.repository.RegiaoRepository;
import com.cce.challenge.repository.entity.Regiao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoServiceImpl implements RegiaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegiaoServiceImpl.class);

    private final RegiaoRepository regiaoRepository;

    public RegiaoServiceImpl(RegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }

    @Override
    public Regiao searchValuesByRegiao(String sigla) {
        List<Regiao> regiao = regiaoRepository.findRegiaoBySigla(sigla);
        if (regiao != null && regiao.size() > 0) {
            Regiao regiaoConsolidate = new Regiao();
            regiaoConsolidate.setSigla(sigla);
            regiaoConsolidate.setGeracao(regiao.stream().mapToDouble(r -> r.getGeracao()).sum());
            regiaoConsolidate.setCompra(regiao.stream().mapToDouble(r -> r.getCompra()).sum());
            return regiaoConsolidate;
        }
        return null;
    }
}

