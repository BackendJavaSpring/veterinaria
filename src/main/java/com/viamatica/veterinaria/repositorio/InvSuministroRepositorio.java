package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.InvSuministro;

@Repository
public interface InvSuministroRepositorio  extends JpaRepository<InvSuministro, Integer>{

}
