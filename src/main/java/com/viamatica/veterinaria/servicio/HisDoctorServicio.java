package com.viamatica.veterinaria.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viamatica.veterinaria.modelo.HisDoctor;
import com.viamatica.veterinaria.repositorio.HisDoctorRepositorio;

@Service
public class HisDoctorServicio {

	@Autowired
    HisDoctorRepositorio hisDoctorRepositorio;
	

    public List<HisDoctor> ObtenerListado(){

        return hisDoctorRepositorio.findAll();

    }

    public Optional<HisDoctor> ObtenerId(int id){

        return hisDoctorRepositorio.findById(id);

    }

    public void GuardaActualiza(HisDoctor hisDoctor){

        hisDoctorRepositorio.save(hisDoctor);

    }


    public void BorrarId(int id){

        hisDoctorRepositorio.deleteById(id);
    }	
	
    
    
}