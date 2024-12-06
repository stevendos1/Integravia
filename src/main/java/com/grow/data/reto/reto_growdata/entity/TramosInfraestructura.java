package com.grow.data.reto.reto_growdata.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tramos_infraestructura")
public class TramosInfraestructura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTramo;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "idRuta")
    private Ruta ruta;

    @Column(name = "tipo_infraestructura")
    private String tipoInfraestructura;

    private String estado;
    private String departamento;

    @Column(name = "f_ultima_inspeccion")
    private Date ultimaInspeccion;

    public TramosInfraestructura() {
    }

    public TramosInfraestructura(Ruta ruta, String tipoInfraestructura, String estado, String departamento,
            Date ultimaInspeccion) {
        this.ruta = ruta;
        this.tipoInfraestructura = tipoInfraestructura;
        this.estado = estado;
        this.departamento = departamento;
        this.ultimaInspeccion = ultimaInspeccion;
    }

    public Integer getIdTramo() {
        return idTramo;
    }

    public void setIdTramo(Integer idTramo) {
        this.idTramo = idTramo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public String getTipoInfraestructura() {
        return tipoInfraestructura;
    }

    public void setTipoInfraestructura(String tipoInfraestructura) {
        this.tipoInfraestructura = tipoInfraestructura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getUltimaInspeccion() {
        return ultimaInspeccion;
    }

    public void setUltimaInspeccion(Date ultimaInspeccion) {
        this.ultimaInspeccion = ultimaInspeccion;
    }

    @Override
    public String toString() {
        return "TramosInfraestructura [idTramo=" + idTramo + ", ruta=" + ruta + ", tipoInfraestructura="
                + tipoInfraestructura + ", estado=" + estado + ", departamento=" + departamento + ", ultimaInspeccion="
                + ultimaInspeccion + "]";
    }

}
