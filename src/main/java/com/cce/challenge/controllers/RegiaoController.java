package com.cce.challenge.controllers;

import com.cce.challenge.repository.entity.Regiao;
import com.cce.challenge.services.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin("*")
@RestController
public class RegiaoController {

    private final RegiaoService regiaoService;

    @Autowired
    public RegiaoController(RegiaoService regiaoService) {
        this.regiaoService = regiaoService;
    }

    @GetMapping("/regiao/{sigla}")
    public ResponseEntity<Regiao> ListValueByRegion(@PathVariable  String sigla) throws IOException {
        Regiao regiao = regiaoService.searchValuesByRegiao(sigla);
        if (regiao != null) {
            return ResponseEntity.ok().body(regiao);
        }
        return ResponseEntity.notFound().build();
    }

}