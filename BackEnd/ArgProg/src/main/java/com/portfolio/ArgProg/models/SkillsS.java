package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skillss")
public class SkillsS implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_skills",nullable = false)
    private Long idSkillS;
    @Column(name = "icono_skills",nullable = false)
    private String iconoSkillS;
    @Column(name = "titulo_skills",nullable = false)
    private String tituloSkillS;
    @Column(name = "prog_skills",nullable = false)
    private int progSkillS;

    public SkillsS() {
    }

    public SkillsS(Long idSkillS, String iconoSkillS, String tituloSkillS, int progSkillS) {
        this.idSkillS = idSkillS;
        this.iconoSkillS = iconoSkillS;
        this.tituloSkillS = tituloSkillS;
        this.progSkillS = progSkillS;
    }

    public Long getIdSkillS() {
        return idSkillS;
    }

    public void setIdSkillS(Long idSkillS) {
        this.idSkillS = idSkillS;
    }

    public String getIconoSkillS() {
        return iconoSkillS;
    }

    public void setIconoSkillS(String iconoSkillS) {
        this.iconoSkillS = iconoSkillS;
    }

    public String getTituloSkillS() {
        return tituloSkillS;
    }

    public void setTituloSkillS(String tituloSkillS) {
        this.tituloSkillS = tituloSkillS;
    }

    public int getProgSkillS() {
        return progSkillS;
    }

    public void setProgSkillS(int progSkillS) {
        this.progSkillS = progSkillS;
    }
}
