package com.viamatica.veterinaria.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="GesCliente" , schema="dbo")
public class GesCliente {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idCliente" , unique=true)
	    private int idCliente;
	
	    @Column(name = "numDocumento", length = 13, unique=true, nullable = false)
	    private String numDocumento;
	
	    @Column(name = "nombreCliente", length = 30,unique=true, nullable = false)
	    private String nombreCliente;
	
	    @Column(name = "apellidoCliente", length = 30, unique=true, nullable = false)
	    private String apellidoCliente;
	
	    @Column(name = "fechaNac",nullable = false)
	    private LocalDate fechaNac;
	
	    @Column(name = "telefono", length = 10,unique=true, nullable = false)
	    private String telefono;
	
	    @Column(name = "direccion", length = 100,unique=true, nullable = false)
	    private String direccion;
	
	    @Column(name = "correo",unique=true, length = 100)
	    private String correo;
	
	    @Column(name = "estadoCliente", length = 1, nullable = false)
	    private String estadoCliente;
	
	    @Column(name = "fechaCreacion", nullable = false)
	    private LocalDateTime fechaCreacion;
	
	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion;
	
	    @Column(name = "fechaEliminacion")
	    private LocalDateTime fechaEliminacion;
	
	    @ManyToOne
	    @JoinColumn(name="idUsuario" , referencedColumnName="idUsuario", nullable=false)
	    private SegUsuario segUsuario;

		
	    
	
}
