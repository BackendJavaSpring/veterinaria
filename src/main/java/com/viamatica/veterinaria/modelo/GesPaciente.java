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
@Table(name="GesPaciente" , schema="dbo")
public class GesPaciente{
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idPaciente")
	    private int idPaciente;

	    @Column(name = "nombrePaciente", length = 30, nullable = false)
	    private String nombrePaciente;

	    @Column(name = "fechaNac", nullable = false)
	    private LocalDate fechaNac;

	    @Column(name = "edad", nullable = false)
	    private int edad;

	    @Column(name = "raza", length = 20, nullable = false)
	    private String raza;

	    @ManyToOne
	    @JoinColumn(name = "idTipoPaciente", nullable = false)
	    private GesTipopaciente tipoPaciente;

	    @ManyToOne
	    @JoinColumn(name = "idCliente", nullable = false)
	    private GesCliente cliente;

	    @Column(name = "estadoPaciente", length = 1, nullable = false)
	    private String estadoPaciente;

	    @Column(name = "fechaCreacion", nullable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion;
}



