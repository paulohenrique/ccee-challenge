package com.cce.challenge.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Regiao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigla;

    private Double geracao;
    private Double compra;

    @ManyToOne
    @JsonBackReference
    private Agente agente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Double getGeracao() {
        return geracao;
    }

    public void setGeracao(Double geracao) {
        this.geracao = geracao;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    @Override
    public String toString() {
        return "sigla= " + sigla + "geracao: " + geracao + "compra: " + compra;
    }

}
