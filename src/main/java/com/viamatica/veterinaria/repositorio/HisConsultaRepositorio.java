package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HisConsulta;

@Repository
public interface HisConsultaRepositorio  extends JpaRepository<HisConsulta , Integer> {
    
}
