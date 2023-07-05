package com.viamatica.veterinaria.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="GesTipopaciente" , schema="dbo")
public class GesTipopaciente {

	
	@Id
    @Column(name = "idTipoPaciente", length = 1)
    private String idTipoPaciente;

    @Column(name = "tipoPaciente", length = 20, nullable = false)
    private String tipoPaciente;

    @Column(name = "estadoTipoPaciente", length = 1, nullable = false)
    private String estadoTipoPaciente;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fechaEliminacion")
    private LocalDateTime fechaEliminacion;
	
}
