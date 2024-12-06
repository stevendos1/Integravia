package com.grow.data.reto.reto_growdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trafico_movilidad")
public class TraficoMovilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tramo;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "idRuta")
    private Ruta ruta;

    @Column(name = "conteo_vehicular")
    private Integer conteoVehicular;

    @Column(name = "velocidad_promedio")
    private Double velocidadPromedio;

    @Column(name = "eventos_reportados")
    private String eventosReportados;

    public TraficoMovilidad() {
    }

    public TraficoMovilidad(Ruta ruta, Integer conteoVehicular, Double velocidadPromedio, String eventosReportados) {
        this.ruta = ruta;
        this.conteoVehicular = conteoVehicular;
        this.velocidadPromedio = velocidadPromedio;
        this.eventosReportados = eventosReportados;
    }

    public Integer getTramo() {
        return tramo;
    }

    public void setTramo(Integer tramo) {
        this.tramo = tramo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Integer getConteoVehicular() {
        return conteoVehicular;
    }

    public void setConteoVehicular(Integer conteoVehicular) {
        this.conteoVehicular = conteoVehicular;
    }

    public Double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(Double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public String getEventosReportados() {
        return eventosReportados;
    }

    public void setEventosReportados(String eventosReportados) {
        this.eventosReportados = eventosReportados;
    }

    @Override
    public String toString() {
        return "TraficoMovilidad [tramo=" + tramo + ", ruta=" + ruta + ", conteoVehicular=" + conteoVehicular
                + ", velocidadPromedio=" + velocidadPromedio + ", eventosReportados=" + eventosReportados + "]";
    }

}
