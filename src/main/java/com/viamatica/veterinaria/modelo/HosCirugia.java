package com.viamatica.veterinaria.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HosCirugia", schema = "dbo")
public class HosCirugia {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHosCirugia")
    private int idHosCirguia;

    @Column(name = "idPaciente")
    private int idPaciente;

    @Column(name = "tipoCirugia")
    private String tipoCirugia;

    @Column(name = "fechaProgramada")
    private Date fechaProgramada;

    @Column(name = "idDoctor")
    private int idDoctor;

    @Column(name = "estadoCirugia")
    private String estadoCirugia;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "fechaActualizacion")
    private Date fechaActualizacion;

    public int getIdHosCirguia() {
        return idHosCirguia;
    }

    public void setIdHosCirguia(int idHosCirguia) {
        this.idHosCirguia = idHosCirguia;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoCirugia() {
        return tipoCirugia;
    }

    public void setTipoCirugia(String tipoCirugia) {
        this.tipoCirugia = tipoCirugia;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getEstadoCirugia() {
        return estadoCirugia;
    }

    public void setEstadoCirugia(String estadoCirugia) {
        this.estadoCirugia = estadoCirugia;
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
