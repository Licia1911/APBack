package com.portfolio.ArgProg.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "id_edu")
    private Long idEdu;
    @Column(length = 255, nullable = false, name = "titulo_edu")
    private String tituloEdu;
    @Column(length = 500, name = "desc_edu", nullable = false)
    private String descEdu;

    public Educacion() {
    }

    public Educacion(Long idEdu, String tituloEdu, String descEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.descEdu = descEdu;
    }

    public Long getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(Long idEdu) {
        this.idEdu = idEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(String descEdu) {
        this.descEdu = descEdu;
    }
}
