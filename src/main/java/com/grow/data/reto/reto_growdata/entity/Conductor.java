package com.grow.data.reto.reto_growdata.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "conductor")
public class Conductor {
    @Id
    private Integer cedula;

    @ManyToOne
    @JoinColumn(name = "id_flota", referencedColumnName = "id_vehiculo")
    private FlotaVehiculos flotaVehiculos;

    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL)
    private List<Ruta> rutas;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "f_expedicion")
    private String fechaExpedicion;

    @Column(name = "f_vencimiento")
    private String fechaVencimiento;

    @Column(name = "historial_multas")
    private String historialMultas;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "no_licencia")
    private String noLicencia;

    private String password;

    // Constructor vacío
    public Conductor() {
    }

    // Constructor con parámetros
    public Conductor(Integer cedula, FlotaVehiculos flotaVehiculos, List<Ruta> rutas, String nombre, String categoria,
            String fechaExpedicion, String fechaVencimiento, String historialMultas, String gmail,
            String noLicencia, String password) {
        this.cedula = cedula;
        this.flotaVehiculos = flotaVehiculos;
        this.rutas = rutas;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.historialMultas = historialMultas;
        this.gmail = gmail;
        this.noLicencia = noLicencia;
        this.password = password;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public FlotaVehiculos getFlotaVehiculos() {
        return flotaVehiculos;
    }

    public void setFlotaVehiculos(FlotaVehiculos flotaVehiculos) {
        this.flotaVehiculos = flotaVehiculos;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getHistorialMultas() {
        return historialMultas;
    }

    public void setHistorialMultas(String historialMultas) {
        this.historialMultas = historialMultas;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(String noLicencia) {
        this.noLicencia = noLicencia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Conductor [cedula=" + cedula + ", flotaVehiculos=" + flotaVehiculos + ", rutas=" + rutas + ", nombre="
                + nombre + ", categoria=" + categoria + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento="
                + fechaVencimiento + ", historialMultas=" + historialMultas + ", gmail=" + gmail + ", noLicencia="
                + noLicencia + ", password=" + password + "]";
    }

}
