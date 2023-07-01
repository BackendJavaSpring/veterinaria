package com.viamatica.veterinaria.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HosHospitalizacionPaciente", schema = "dbo")
public class HosHospitalizacionPaciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHospitalizacion;

    @Column(name = "idPaciente")
    private int idPaciente;

    @Column(name = "fechaIngreso")
    private Date fechaIngreso;

    @Column(name = "fechaSalida")
    private Date fechaSalida;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "fechaActualizacion")
    private Date fechaActualizacion;

    public int getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(int idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
