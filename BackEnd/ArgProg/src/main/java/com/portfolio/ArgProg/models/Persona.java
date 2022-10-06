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
    private String descripcion;
    private String fotoPerfil;
    private String github;
    private String linkedIn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="idEdu")
    private List<Educacion>educacionList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idExp")
    private List<Experiencia>experienciaList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idSkill")
    private List<Skills>skillsList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idPro")
    private List<Proyectos>proyectosList;

    public Persona() {
    }

    public Persona(Long id, String nombre, String titulo, String descripcion, String fotoPerfil, String github, String linkedIn) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
        this.github = github;
        this.linkedIn = linkedIn;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}
