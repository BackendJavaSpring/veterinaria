package com.viamatica.veterinaria.repositorio;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HisCitaMedica;

@Repository
public interface HisCitaMedicaRepositorio  extends JpaRepository<HisCitaMedica , Integer>{
    
	
	
	
	
}

