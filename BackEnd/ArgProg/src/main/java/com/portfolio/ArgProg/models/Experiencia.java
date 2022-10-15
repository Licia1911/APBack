package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "experiencia")
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,name = "id_exp")
    private Long idExp;
    @Column(length = 255,nullable = false,name = "titulo_exp")
    private String tituloExp;
    @Column(length = 255,nullable = false,name = "fecha_exp")
    private String fechaExp;
    @Column(length = 1000,name = "desc_exp",nullable = false)
    private String descExp;

    public Experiencia() {
    }

    public Experiencia(Long idExp, String tituloExp, String fechaExp, String descExp) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descExp = descExp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }
}
