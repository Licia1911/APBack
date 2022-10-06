package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String titulo;
    private String desc;
    private String fotoPerfil;
    private String git;
    private String link;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion>educacionList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "idExp")
    private List<Experiencia>experienciaList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "idSkill")
    private List<Skills>skillsList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "idPro")
    private List<Proyectos>proyectosList;


    public Persona() {
    }

    public Persona(Long id, String nombre, String titulo, String desc, String fotoPerfil, String git, String link) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.desc = desc;
        this.fotoPerfil = fotoPerfil;
        this.git = git;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
