package com.viamatica.veterinaria.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viamatica.veterinaria.modelo.GesPaciente;
import com.viamatica.veterinaria.repositorio.GesPacienteRepositorio;

@Service
public class GesPacienteServicio {

	@Autowired
	private GesPacienteRepositorio gesPacienteRepositorio;



	public List<GesPaciente> obtener () {
		
		return gesPacienteRepositorio.findAll();
		
	}
	
	
	public Optional<GesPaciente>obtenerPorId(int id){
		
		return gesPacienteRepositorio.findById(id);
		
		
	}
	
}