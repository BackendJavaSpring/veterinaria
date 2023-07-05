package com.viamatica.veterinaria.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viamatica.veterinaria.modelo.GesCliente;
import com.viamatica.veterinaria.repositorio.GesClienteRepositorio;

@Service
public class GesClienteServicio {
	
	@Autowired
	GesClienteRepositorio   gesClienteRepositorio;
	
	
	
	public List<GesCliente> obtener()	{
		
		return gesClienteRepositorio.findAll();
	}



    public Optional<GesCliente> ObtenerId(int id){

        return gesClienteRepositorio.findById(id);

    }

}
