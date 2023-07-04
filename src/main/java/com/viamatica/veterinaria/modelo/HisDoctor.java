package com.viamatica.veterinaria.modelo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="HisDoctor" , schema="dbo")
public class HisDoctor {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idDoctor")
	    private int idDoctor;

	
	    @Column(name = "idUsuario" , nullable=false)
	    private int idUsuario;

	   
	    @Column(name = "cedula", length = 20, nullable=false)
	    private String cedula;

	    @Column(name = "edad" , nullable=false )
	    private int edad;

	    @Column(name = "telefono", length = 10 , nullable=false)
	    private String telefono;

	    @Column(name = "especialidad", length = 20 , nullable=false)
	    private String especialidad;

	    @Column(name = "fechaCreacion" ,nullable=false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion;

	    @Column(name = "estadoDoctor", length = 1 , nullable=false)
	    private String estadoDoctor;
	
	
}
