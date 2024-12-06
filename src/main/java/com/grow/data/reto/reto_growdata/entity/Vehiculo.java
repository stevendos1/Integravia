package com.grow.data.reto.reto_growdata.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    private Integer vin;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Infraccion> infracciones; // Cambiado a Infraccion (mayúscula inicial)

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Poliza> polizas;

    private String placa;
    private Date fechaMatricula;
    private String marca;
    private String modelo;
    private String tipo;
    private String estado;

    // Constructor vacío
    public Vehiculo() {
    }

    // Constructor con parámetros
    public Vehiculo(Integer vin, List<Infraccion> infracciones, List<Poliza> polizas, String placa, Date fechaMatricula,
            String marca, String modelo, String tipo, String estado) {
        this.vin = vin;
        this.infracciones = infracciones;
        this.polizas = polizas;
        this.placa = placa;
        this.fechaMatricula = fechaMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
