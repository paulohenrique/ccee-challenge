package com.cce.challenge.services;

import com.cce.challenge.repository.AgenteRepository;
import com.cce.challenge.repository.entity.Agente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AgenteServiceImpl implements AgenteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgenteServiceImpl.class);

    private final AgenteRepository agenteRepository;

    public AgenteServiceImpl(AgenteRepository agenteRepository) {
        this.agenteRepository = agenteRepository;
    }

    @Override
    public Agente create(Agente agente) {
            LOGGER.debug("Creating a new agent with regiao: {}", agente.getRegiao());
            return agenteRepository.save(agente);
    }
}
