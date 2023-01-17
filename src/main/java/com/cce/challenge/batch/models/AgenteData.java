package com.cce.challenge.batch.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "agente")
public class AgenteData {

    private Long id;
    private String codigo;
    private String data;

    @XmlElement(name = "regiao")
    private List<RegiaoData> regiaos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<RegiaoData> getRegiaos() {
        return regiaos;
    }

    public void setRegiaos(List<RegiaoData> regiaos) {
        if (this.regiaos == null) {
            this.regiaos = new ArrayList<>();
        } else {
            this.regiaos.clear();
        }
        this.regiaos.addAll(regiaos);
    }

    @Override
    public String toString() {
        return "codigo= " + codigo + " data: " + data + " regiao: " + regiaos;
    }
}
