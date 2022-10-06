package com.portfolio.ArgProg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPro;
    private String imgPro;
    private String tituloPro;
    private String descPro;

    public Proyectos() {
    }

    public Proyectos(Long idPro, String imgPro, String tituloPro, String descPro) {
        this.idPro = idPro;
        this.imgPro = imgPro;
        this.tituloPro = tituloPro;
        this.descPro = descPro;
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }

    public String getTituloPro() {
        return tituloPro;
    }

    public void setTituloPro(String tituloPro) {
        this.tituloPro = tituloPro;
    }

    public String getDescPro() {
        return descPro;
    }

    public void setDescPro(String descPro) {
        this.descPro = descPro;
    }
}
