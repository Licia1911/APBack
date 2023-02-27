package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skillsb")
public class SkillsB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_skillb",nullable = false)
    private Long idSkillB;
    @Column(name = "icono_skillb",nullable = false)
    private String iconoSkillB;
    @Column(name = "titulo_skillb",nullable = false)
    private String tituloSkillB;
    @Column(name = "prog_skillb",nullable = false)
    private int progSkillB;

    public SkillsB() {
    }

    public SkillsB(Long idSkillB, String iconoSkillB, String tituloSkillB, int progSkillB) {
        this.idSkillB = idSkillB;
        this.iconoSkillB = iconoSkillB;
        this.tituloSkillB = tituloSkillB;
        this.progSkillB = progSkillB;
    }

    public Long getIdSkillB() {
        return idSkillB;
    }

    public void setIdSkillB(Long idSkillB) {
        this.idSkillB = idSkillB;
    }

    public String getIconoSkillB() {
        return iconoSkillB;
    }

    public void setIconoSkillB(String iconoSkillB) {
        this.iconoSkillB = iconoSkillB;
    }

    public String getTituloSkillB() {
        return tituloSkillB;
    }

    public void setTituloSkillB(String tituloSkillB) {
        this.tituloSkillB = tituloSkillB;
    }

    public int getProgSkillB() {
        return progSkillB;
    }

    public void setProgSkillB(int progSkillB) {
        this.progSkillB = progSkillB;
    }
}
