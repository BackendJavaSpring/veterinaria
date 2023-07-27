package com.viamatica.veterinaria.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viamatica.veterinaria.modelo.HisHistoriaClinica;
import com.viamatica.veterinaria.repositorio.HisHistoriaClinicaRepositorio;

@Service
public class HisHistoriaClinicaServicio {
    

        @Autowired
        HisHistoriaClinicaRepositorio hisHistoriaClinicaRepositorio;


	    public List<HisHistoriaClinica> ObtenerListado(){
	    	
	        return hisHistoriaClinicaRepositorio.findAll();
	       
	
	    }
	
	    public Optional<HisHistoriaClinica> ObtenerId(int id){
	    	
	        return hisHistoriaClinicaRepositorio.findById(id);  
	       
	
	    }
	
	    public void Guarda(HisHistoriaClinica hisHistoriaClinica){
	    	
	    	hisHistoriaClinicaRepositorio.save(hisHistoriaClinica);
	
	    }
	    
	    
	    public boolean VerificarIdPaciente(int id) {
	        List<HisHistoriaClinica> ListHistoriaClinica = hisHistoriaClinicaRepositorio.findAll();

	        for (HisHistoriaClinica hisHistoriaClinica1 : ListHistoriaClinica) {
	            if (hisHistoriaClinica1.getGesPaciente().equals(id)) {
	                return true; // El paciente ya existe
	            }
	        }

	        return false; // el paciente no existe
	    }
	
	
	    public void BorrarId(int id){
		
	    	HisHistoriaClinica hisHistoriaClinica=hisHistoriaClinicaRepositorio.getReferenceById(id);

		    	if(hisHistoriaClinica != null){
		    		hisHistoriaClinica.setEstadoHistoriaClinica("I");
		    		hisHistoriaClinica.setFechaEliminacion(LocalDateTime.now());
		    		hisHistoriaClinicaRepositorio.save(hisHistoriaClinica);
				}
		}			
        















}
