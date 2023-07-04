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

@Data
@Entity
@Table(name="SegUsuario" , schema="dbo")
public class SegUsuario {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idUsuario")
	    private Integer idUsuario;

	    @Column(name = "nombreUsuario", nullable = false, length = 20)
	    private String nombreUsuario;

	    @Column(name = "contrasenia", nullable = false, length = 20)
	    private String contrasenia;

	    @Column(name = "correo", nullable = false, length = 50)
	    private String correo;

	    //@Column(name = "bloqueado", nullable = false)
	    //private bit bloqueado;

	    @Column(name = "estadoUsuario", nullable = false, length = 1)
	    private String estadoUsuario;

	    @Column(name = "fechaCreacion", nullable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion;

	    //@ManyToOne
	    //@JoinColumn(name = "idPerfil", nullable = false)
	   // private SegPerfil segPerfil;
	
	
}
