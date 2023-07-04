
package com.viamatica.veterinaria.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HosRevisionDiaria", schema = "dbo")
public class HosRevisionDiaria
{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRevisionDiaria;

    @Column(name = "fechaRevision")
    private Date fechaRevision;

    @Column(name = "idPaciente")
    private int idPaciente;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "fechaActualizacion")
    private Date fechaActulizacion;

    @Column(name = "estado")
    private String estado;

    public int getIdRevisionDiaria() {
        return idRevisionDiaria;
    }

    public void setIdRevisionDiaria(int idRevisionDiaria) {
        this.idRevisionDiaria = idRevisionDiaria;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActulizacion() {
        return fechaActulizacion;
    }

    public void setFechaActulizacion(Date fechaActulizacion) {
        this.fechaActulizacion = fechaActulizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}