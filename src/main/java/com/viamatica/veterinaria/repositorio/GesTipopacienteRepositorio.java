package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.GesTipopaciente;

@Repository
public interface GesTipopacienteRepositorio  extends JpaRepository<GesTipopaciente,Integer>{

	
}
