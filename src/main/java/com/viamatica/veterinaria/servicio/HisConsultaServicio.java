package com.viamatica.veterinaria.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viamatica.veterinaria.modelo.HisConsulta;
import com.viamatica.veterinaria.repositorio.HisConsultaRepositorio;

@Service
public class HisConsultaServicio {
		
	@Autowired
	HisConsultaRepositorio hisConsultaRepositorio;


	public List<HisConsulta> obtener() {
		return hisConsultaRepositorio.findAll();

	}

	public Optional<HisConsulta> obtenerPorId(int id) {
		return hisConsultaRepositorio.findById(id);

	}

	public void Guarda(HisConsulta hisConsulta1) {
		hisConsultaRepositorio.save(hisConsulta1);

	}

	public boolean VerificarPorIdDoctor(int id) {
		List<HisConsulta> listConsulta = hisConsultaRepositorio.findAll();

		for (HisConsulta hisConsulta1 : listConsulta) {
			if (hisConsulta1.getDoctor().equals(id)) {
				return true; // el doctor ya existe
			}
		}

		return false; // el doctor no existe
	}

	public void BorrarId(int id) {
		HisConsulta hisConsulta = hisConsultaRepositorio.getReferenceById(id);

		hisConsulta.setEstadoConsulta("I");
		hisConsulta.setFechaEliminacion(LocalDateTime.now());
		hisConsultaRepositorio.save(hisConsulta);
	}
			
	
}





