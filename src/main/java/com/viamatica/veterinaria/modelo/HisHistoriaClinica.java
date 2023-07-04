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
@Table(name="HisHistoriaClinica" , schema="dbo")
public class HisHistoriaClinica {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idHistoriaCli")
	    private int idHistoriaCli;

	    @Column(name = "fechaIngreso", nullable = false)
	    private LocalDate fechaIngreso;

	    @Column(name = "descripcion", length = 200, nullable = false)
	    private String descripcion;

	    @ManyToOne
	    @JoinColumn(name = "idConsulta", nullable = false)
	    private HisConsulta consulta;

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
	
}
