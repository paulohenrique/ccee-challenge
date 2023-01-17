package com.cce.challenge.repository.entity;

import com.cce.challenge.batch.models.RegiaoData;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime data;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Regiao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "agente_id")
    @JsonManagedReference
    private List<Regiao> regiaos;

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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<Regiao> getRegiao() {
        return regiaos;
    }

    public void setRegiao(List<Regiao> regiaos) {
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
