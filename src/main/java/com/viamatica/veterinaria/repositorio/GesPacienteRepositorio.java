package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.GesPaciente;

@Repository
public interface GesPacienteRepositorio  extends JpaRepository<GesPaciente, Integer>{
    
}