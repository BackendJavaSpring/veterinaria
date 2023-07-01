
package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HosRevisionDiaria;

@Repository
public interface HosRevisionDiariaRepositorio extends JpaRepository<HosRevisionDiaria, Integer>{
    

}