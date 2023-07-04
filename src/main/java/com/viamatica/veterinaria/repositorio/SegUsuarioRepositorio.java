package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.SegUsuario;

@Repository
public interface SegUsuarioRepositorio extends JpaRepository<SegUsuario, Integer> {

}
