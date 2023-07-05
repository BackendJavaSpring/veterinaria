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

		@ManyToOne
		@JoinColumn(name = "idConsulta", referencedColumnName = "idConsulta", nullable = false)
		private HisConsulta hisConsulta;
		
		@ManyToOne
		@JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente", nullable = false)
		private GesPaciente gesPaciente;
		
		@ManyToOne
		@JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
		private GesCliente gesCliente;
		
	    @Column(name = "fechaCreacion", nullable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fechaActualizacion")
	    private LocalDateTime fechaActualizacion;

	    @Column(name = "fechaEliminacion")
	    private LocalDateTime fechaEliminacion;
	
}


















