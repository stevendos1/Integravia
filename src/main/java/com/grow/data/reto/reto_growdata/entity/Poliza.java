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
@Table(name = "polizas")
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noPolizas;

    @ManyToOne
    @JoinColumn(name = "vehiculos_VIN", referencedColumnName = "vin")
    private Vehiculo vehiculo;

    private String aseguradora;

    @Column(name = "f_inicio")
    private String fechaInicio;

    @Column(name = "f_vencimiento")
    private String fechaVencimiento;

    public Poliza() {
    }

    public Poliza(Vehiculo vehiculo, String aseguradora, String fechaInicio,
            String fechaVencimiento) {
        this.vehiculo = vehiculo;
        this.aseguradora = aseguradora;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getNoPolizas() {
        return noPolizas;
    }

    public void setNoPolizas(Integer noPolizas) {
        this.noPolizas = noPolizas;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Poliza [noPolizas=" + noPolizas + ", vehiculo=" + vehiculo + ", aseguradora=" + aseguradora
                + ", fechaInicio=" + fechaInicio + ", fechaVencimiento=" + fechaVencimiento + "]";
    }

}
