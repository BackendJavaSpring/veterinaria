package com.viamatica.veterinaria.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="GesCliente" , schema="dbo")
public class GesCliente {
	
	@Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

	 @Column(name = "numDocumento", nullable = false, length = 13)
	    private String numDocumento;

	    @Column(name = "nombreCliente", nullable = false, length = 30)
	    private String nombreCliente;

	    @Column(name = "apellidoCliente", nullable = false, length = 30)
	    private String apellidoCliente;

	    @Column(name = "telefono", nullable = false, length = 10)
	    private String telefono;

	    @Column(name = "direccion", nullable = false, length = 100)
	    private String direccion;

	    @Column(name = "correo",  length = 100)
	    private String correo;

	    @Column(name = "estadoCliente", nullable = false, length = 1)
	    private String estadoCliente;

	    @Column(name = "fechaNac", nullable = false)
	    private LocalDate  fechaNac; 

	    @Column(name = "fechaCreacion", nullable = false)
	    private LocalDateTime  fechaCreacion; 

	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion; 

	
	
}
