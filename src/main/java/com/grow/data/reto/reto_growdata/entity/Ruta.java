package com.grow.data.reto.reto_growdata.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutas")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuta;

    @ManyToOne
    @JoinColumn(name = "conductor_cedula", referencedColumnName = "cedula")
    private Conductor conductor;

    private String origen;
    private String destino;

    @Column(name = "tipo_carga")
    private String tipoCarga;

    @Column(name = "distancia_km")
    private Double distanciaKm;

    @Column(name = "tiempo_estimado_h")
    private Double tiempoEstimadoHoras;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<TraficoIncidentes> traficoIncidentes;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<TraficoMovilidad> traficoMovilidad;

    public Ruta() {
    }

    public Ruta(Conductor conductor, String origen, String destino, String tipoCarga,
            Double distanciaKm, Double tiempoEstimadoHoras, List<TraficoIncidentes> traficoIncidentes,
            List<TraficoMovilidad> traficoMovilidad) {
        this.conductor = conductor;
        this.origen = origen;
        this.destino = destino;
        this.tipoCarga = tipoCarga;
        this.distanciaKm = distanciaKm;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
        this.traficoIncidentes = traficoIncidentes;
        this.traficoMovilidad = traficoMovilidad;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public Double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(Double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public Double getTiempoEstimadoHoras() {
        return tiempoEstimadoHoras;
    }

    public void setTiempoEstimadoHoras(Double tiempoEstimadoHoras) {
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
    }

    public List<TraficoIncidentes> getTraficoIncidentes() {
        return traficoIncidentes;
    }

    public void setTraficoIncidentes(List<TraficoIncidentes> traficoIncidentes) {
        this.traficoIncidentes = traficoIncidentes;
    }

    public List<TraficoMovilidad> getTraficoMovilidad() {
        return traficoMovilidad;
    }

    public void setTraficoMovilidad(List<TraficoMovilidad> traficoMovilidad) {
        this.traficoMovilidad = traficoMovilidad;
    }

    @Override
    public String toString() {
        return "Ruta [idRuta=" + idRuta + ", conductor=" + conductor + ", origen=" + origen + ", destino=" + destino
                + ", tipoCarga=" + tipoCarga + ", distanciaKm=" + distanciaKm + ", tiempoEstimadoHoras="
                + tiempoEstimadoHoras + ", traficoIncidentes=" + traficoIncidentes + ", traficoMovilidad="
                + traficoMovilidad + "]";
    }

}
