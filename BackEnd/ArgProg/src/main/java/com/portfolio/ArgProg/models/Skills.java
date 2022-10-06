package com.portfolio.ArgProg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    private String tituloSkill;
    private int porcentaje;

    public Skills() {
    }

    public Skills(Long idSkill, String tituloSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.tituloSkill = tituloSkill;
        this.porcentaje = porcentaje;
    }

    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getTituloSkill() {
        return tituloSkill;
    }

    public void setTituloSkill(String tituloSkill) {
        this.tituloSkill = tituloSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
