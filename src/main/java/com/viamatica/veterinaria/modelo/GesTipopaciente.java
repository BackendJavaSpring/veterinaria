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
	
}
