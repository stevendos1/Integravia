package com.grow.data.reto.reto_growdata.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "infracciones")
public class Infraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noMulta;

    @ManyToOne
    @JoinColumn(name = "vehiculo_VIN", referencedColumnName = "vin")
    private Vehiculo vehiculo;

    private String fecha;
    private String lugar;

    @Column(name = "tipo_multa")
    private String tipoMulta;

    private BigDecimal valor;
    private String estado;

    public Infraccion() {
    }

    public Infraccion(Integer noMulta, Vehiculo vehiculo, String fecha, String lugar, String tipoMulta,
            BigDecimal valor, String estado) {
        this.noMulta = noMulta;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.tipoMulta = tipoMulta;
        this.valor = valor;
        this.estado = estado;
    }

    public Integer getNoMulta() {
        return noMulta;
    }

    public void setNoMulta(Integer noMulta) {
        this.noMulta = noMulta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(String tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Infraccion [noMulta=" + noMulta + ", vehiculo=" + vehiculo + ", fecha=" + fecha + ", lugar=" + lugar
                + ", tipoMulta=" + tipoMulta + ", valor=" + valor + ", estado=" + estado + "]";
    }

}
