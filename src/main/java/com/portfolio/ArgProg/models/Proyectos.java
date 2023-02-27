package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proyectos")
public class Proyectos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,name = "id_pro")
    private Long idPro;
    @Column(length = 255,nullable = false,name = "img_pro")
    private String imgPro;
    @Column(length = 255,nullable = false,name = "titulo_pro")
    private String tituloPro;
    @Column(length = 255,nullable = false,name = "desc_pro")
    private String descPro;
    @Column(length = 255,nullable = false,name = "demo_url")
    private String demoUrl;
    @Column(length = 255,nullable = false,name = "repo_url")
    private String repoUrl;

    public Proyectos() {
    }

    public Proyectos(Long idPro, String imgPro, String tituloPro, String descPro, String demoUrl, String repoUrl) {
        this.idPro = idPro;
        this.imgPro = imgPro;
        this.tituloPro = tituloPro;
        this.descPro = descPro;
        this.demoUrl = demoUrl;
        this.repoUrl = repoUrl;
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

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }
}
