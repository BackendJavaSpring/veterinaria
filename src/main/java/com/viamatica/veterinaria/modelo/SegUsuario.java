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
		@Column(name = "idUsuario", unique=true)
		private int idUsuario;
	
		@Column(name = "nombreUsuario", length = 20,unique=true, nullable = false)
		private String nombreUsuario;
	
		@Column(name = "contrasenia", length = 20,unique=true, nullable = false)
		private String contrasenia;
	
		@Column(name = "correo", length = 50,unique=true, nullable = false)
		private String correo;

	    @Column(name = "bloqueado", nullable = false)
	    private boolean bloqueado;

		@Column(name = "estadoUsuario", length = 1, nullable = false)
		private String estadoUsuario;
	
		@Column(name = "fechaCreacion", nullable = false)
		private LocalDateTime fechaCreacion;
	
		@Column(name = "fechaActualizacion")
		private LocalDateTime fechaActualizacion;
	
		@Column(name = "fechaEliminacion")
		private LocalDateTime fechaEliminacion;

	    @ManyToOne
	    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil", nullable = false)
	    private SegPerfil segPerfil;
	
	
}

















