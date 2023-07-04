package com.viamatica.veterinaria.modelo;

import java.time.LocalDate;
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
@Table(name="HisConsulta" , schema="dbo")
public class HisConsulta {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idConsulta")
	    private int idConsulta;

	    @Column(name = "consulta", length = 20, nullable = false)
	    private String consulta;

	    @Column(name = "fechaProgramada", nullable = false)
	    private LocalDate fechaProgramada;

	    @ManyToOne
	    @JoinColumn(name = "idDoctor", nullable = false)
	    private HisDoctor doctor;

	    @ManyToOne
	    @JoinColumn(name = "idSuministro", nullable = false)
	    private InvSuministro suministro;

	    @ManyToOne
	    @JoinColumn(name = "idCitaMedica", nullable = false)
	    private HisCitaMedica citaMedica;
	
	

}
