package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HisDoctor;

@Repository
public interface HisDoctorRepositorio  extends JpaRepository<HisDoctor, Integer> {


    
}
