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
@Table(name="HisCitaMedica" , schema="dbo")
public class HisCitaMedica {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idCitaMedica")
	    private int idCitaMedica;

	    @Column(name = "fechaConsulta", nullable = false)
	    private LocalDateTime fechaConsulta;

	    @Column(name = "descripcionCitaMedica", length = 300, nullable = false)
	    private String descripcionCitaMedica;

	    @ManyToOne
	    @JoinColumn(name = "idDoctor", nullable = false)
	    private HisDoctor doctor;

	    @ManyToOne
	    @JoinColumn(name = "idPaciente", nullable = false)
	    private GesPaciente paciente;

	    @ManyToOne
	    @JoinColumn(name = "idCliente", nullable = false)
	    private GesCliente cliente;

	    @Column(name = "fechaCreacion", nullable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion;

	    @Column(name = "estadoCitaMedica", length = 1, nullable = false)
	    private String estadoCitaMedica;
	
	

}
