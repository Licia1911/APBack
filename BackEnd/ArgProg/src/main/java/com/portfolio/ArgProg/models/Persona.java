package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "id")
    private Long id;
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;
    @Column(name = "titulo", length = 255, nullable = false)
    private String titulo;
    @Column(name = "descripcion", length = 1000, nullable = false)
    private String descripcion;
    @Column(name = "foto_perfil", length = 1000, nullable = false)
    private String fotoPerfil;
    @Column(name = "banner", length = 1000, nullable = false)
    private String banner;
    @Column(name = "github", length = 500, nullable = false)
    private String github;
    @Column(name = "linked_in ", length = 500, nullable = false)
    private String linkedIn;


    @OneToMany(fetch = FetchType.LAZY, mappedBy="idEdu")
    private List<Educacion>educacionList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idExp")
    private List<Experiencia>experienciaList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idSkillF")
    private List<SkillsF> skillsFList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idSkillB")
    private List<SkillsB> skillsBList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idSkillS")
    private List<SkillsS> skillsSList;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy="idPro")
    private List<Proyectos>proyectosList;

    public Persona() {
    }

    public Persona(Long id, String nombre, String titulo, String descripcion, String fotoPerfil, String banner, String github, String linkedIn) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
        this.banner = banner;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
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
