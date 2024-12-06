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
@Table(name = "trafico_incidentes")
public class TraficoIncidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncidentes;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "idRuta")
    private Ruta ruta;

    private Date fecha;
    private String ubicacion;

    @Column(name = "tipo_evento")
    private String tipoEvento;

    private String gravedad;

    @Column(name = "velocidad_promedio")
    private String velocidadPromedio;

    public TraficoIncidentes() {
    }

    public TraficoIncidentes(Ruta ruta, Date fecha, String ubicacion, String tipoEvento, String gravedad,
            String velocidadPromedio) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.tipoEvento = tipoEvento;
        this.gravedad = gravedad;
        this.velocidadPromedio = velocidadPromedio;
    }

    public Integer getIdIncidentes() {
        return idIncidentes;
    }

    public void setIdIncidentes(Integer idIncidentes) {
        this.idIncidentes = idIncidentes;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(String velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    @Override
    public String toString() {
        return "TraficoIncidentes [idIncidentes=" + idIncidentes + ", ruta=" + ruta + ", fecha=" + fecha
                + ", ubicacion=" + ubicacion + ", tipoEvento=" + tipoEvento + ", gravedad=" + gravedad
                + ", velocidadPromedio=" + velocidadPromedio + "]";
    }

}
