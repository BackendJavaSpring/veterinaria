package com.viamatica.veterinaria.servicio;

import java.time.LocalDateTime;
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
		
		    
		    public void Guarda(HisDoctor hisDoctor2){
		        hisDoctorRepositorio.save(hisDoctor2);
		
		    }
		
		    
		    
		    public boolean VerificarExistenciaCedula(String cedula) {
		        List<HisDoctor> listaHisDoctor = hisDoctorRepositorio.findAll();

		        for (HisDoctor doctor1 : listaHisDoctor) {
		            if (doctor1.getCedula().equals(cedula)) {
		                return true; // La cédula ya existe
		            }
		        }

		        return false; // La cédula no existe
		    }
		    
		
		   public void eliminar (int id){

				HisDoctor hisDoctor=hisDoctorRepositorio.getReferenceById(id);
				
				if(hisDoctor!= null) {
					
					hisDoctor.setEstadoDoctor("I");
					hisDoctor.setFechaEliminacion(LocalDateTime.now());
					hisDoctorRepositorio.save(hisDoctor);
				}

		   }
	
		
		 



}




