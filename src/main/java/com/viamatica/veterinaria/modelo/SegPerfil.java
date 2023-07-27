package com.viamatica.veterinaria.modelo;


import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="SegPerfil" , schema="dbo")
public class SegPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerfil" , unique=true)
    private int idPerfil;

    @Column(name = "nombrePerfil", length = 20, nullable = false)
    private String nombrePerfil;

    @Column(name = "estadoPerfil", length = 1, nullable = false)
    private String estadoPerfil;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fechaEliminacion")
    private LocalDateTime fechaEliminacion;


	
      
	
}
