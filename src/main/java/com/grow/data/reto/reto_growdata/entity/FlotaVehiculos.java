package com.grow.data.reto.reto_growdata.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flota_vehiculos")
public class FlotaVehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private int idVehiculo;

    @OneToMany(mappedBy = "flotaVehiculos", cascade = CascadeType.ALL)
    private List<Conductor> conductores;

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    @Column(name = "capacidad_carga")
    private String capacidadCarga;

    private String placa;

    @Column(name = "empresa_operadora")
    private String empresaOperadora;

    public FlotaVehiculos() {
    }

    public FlotaVehiculos(List<Conductor> conductores, String tipoVehiculo, String capacidadCarga,
            String placa, String empresaOperadora) {
        this.conductores = conductores;
        this.tipoVehiculo = tipoVehiculo;
        this.capacidadCarga = capacidadCarga;
        this.placa = placa;
        this.empresaOperadora = empresaOperadora;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(String capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEmpresaOperadora() {
        return empresaOperadora;
    }

    public void setEmpresaOperadora(String empresaOperadora) {
        this.empresaOperadora = empresaOperadora;
    }

    @Override
    public String toString() {
        return "FlotaVehiculos [idVehiculo=" + idVehiculo + ", conductores=" + conductores + ", tipoVehiculo="
                + tipoVehiculo + ", capacidadCarga=" + capacidadCarga + ", placa=" + placa + ", empresaOperadora="
                + empresaOperadora + "]";
    }

}
