package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HosHospitalizacionPaciente;

@Repository
public interface HosHospitalizacionPacienteRepositorio extends JpaRepository<HosHospitalizacionPaciente, Integer>{}