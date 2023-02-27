package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skillsf")
public class SkillsF implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_skillf",nullable = false)
    private Long idSkillF;
    @Column(name = "icono_skillf",nullable = false)
    private String iconoSkillF;
    @Column(name = "titulo_skillf",nullable = false)
    private String tituloSkillF;
    @Column(name = "prog_skillf",nullable = false)
    private int progSkillF;

    public SkillsF() {
    }

    public SkillsF(Long idSkillF, String iconoSkillF, String tituloSkillF, int progSkillF) {
        this.idSkillF = idSkillF;
        this.iconoSkillF = iconoSkillF;
        this.tituloSkillF = tituloSkillF;
        this.progSkillF = progSkillF;
    }

    public Long getIdSkillF() {
        return idSkillF;
    }

    public void setIdSkillF(Long idSkillF) {
        this.idSkillF = idSkillF;
    }

    public String getIconoSkillF() {
        return iconoSkillF;
    }

    public void setIconoSkillF(String iconoSkillF) {
        this.iconoSkillF = iconoSkillF;
    }

    public String getTituloSkillF() {
        return tituloSkillF;
    }

    public void setTituloSkillF(String tituloSkillF) {
        this.tituloSkillF = tituloSkillF;
    }

    public int getProgSkillF() {
        return progSkillF;
    }

    public void setProgSkillF(int progSkillF) {
        this.progSkillF = progSkillF;
    }
}
