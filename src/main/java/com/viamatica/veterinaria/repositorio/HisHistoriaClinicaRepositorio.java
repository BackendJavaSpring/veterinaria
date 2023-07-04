package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HisHistoriaClinica;

@Repository
public interface HisHistoriaClinicaRepositorio  extends JpaRepository<HisHistoriaClinica , Integer> {
    
}
