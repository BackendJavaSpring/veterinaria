package com.viamatica.veterinaria.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viamatica.veterinaria.modelo.GesTipopaciente;
import com.viamatica.veterinaria.repositorio.GesTipopacienteRepositorio;

@Service
public class GesTipopacienteServicio {

	@Autowired
	GesTipopacienteRepositorio gesTipopacienteRepositorio;
	
	
	public List<GesTipopaciente> obtener(){
		
		return gesTipopacienteRepositorio.findAll();
		
	}
	
	public Optional<GesTipopaciente> obtenerPorId(int id){
		
		return gesTipopacienteRepositorio.findById(id);
		
	}
	
	
	
}
