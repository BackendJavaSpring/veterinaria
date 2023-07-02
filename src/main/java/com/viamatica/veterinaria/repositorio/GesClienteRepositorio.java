package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.GesCliente;


@Repository
public interface GesClienteRepositorio  extends JpaRepository<GesCliente, Integer> {

}
