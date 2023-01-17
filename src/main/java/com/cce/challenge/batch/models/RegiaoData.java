package com.cce.challenge.batch.models;


import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "regiao")
public class RegiaoData {

    private Long id;

    @XmlAttribute(name = "sigla")
    private String sigla;

    @XmlElementWrapper(name = "geracao")
    @XmlElement(name = "valor")
    private List<Double> geracao = new ArrayList<>();
    @XmlElementWrapper(name = "compra")
    @XmlElement(name = "valor")
    private List<Double> compra = new ArrayList<>();
    private List<Double> precoMedio = new ArrayList<>();

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

    public List<Double> getGeracao() {
        return geracao;
    }

    public void setGeracao(List<Double> geracao) {
        this.geracao = geracao;
    }

    public List<Double> getCompra() {
        return compra;
    }

    public void setCompra(List<Double> compra) {
        this.compra = compra;
    }

    public List<Double> getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(List<Double> precoMedio) {
        this.precoMedio = precoMedio;
    }

    @Override
    public String toString() {
        return "sigla= " + sigla + "geracao: " + geracao + "compra: " + compra + "precoMedio: " + precoMedio;
    }
}
