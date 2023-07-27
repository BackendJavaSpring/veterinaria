package com.viamatica.veterinaria.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viamatica.veterinaria.modelo.HisCitaMedica;
import com.viamatica.veterinaria.repositorio.HisCitaMedicaRepositorio;

@Service
public class HisCitaMedicaServicio {
	
	@Autowired
	private HisCitaMedicaRepositorio hisCitaMedicaRepositorio;
	
	
	

	    public List<HisCitaMedica> ObtenerListado(){
	
	        return hisCitaMedicaRepositorio.findAll();
	       
	
	    }
	
	    public Optional<HisCitaMedica> ObtenerId(int id){
	  
	        return hisCitaMedicaRepositorio.findById(id);  
	       
	
	    }
	
	    public void Guarda(HisCitaMedica hisCitaMedica){
	    	
	    	hisCitaMedicaRepositorio.save(hisCitaMedica);
	
	    }
	    
	    
	    public boolean VerificarIdPaciente(int id) {
	        List<HisCitaMedica> listaHisCita = hisCitaMedicaRepositorio.findAll();

	        for (HisCitaMedica hisCitaMedica1 : listaHisCita) {
	        	System.out.println(hisCitaMedica1.getGesPaciente().getIdPaciente());
	            if (hisCitaMedica1.getGesPaciente().getIdPaciente()==id){
	                return true; // El cliente ya existe
	            }
	        }

	        return false; // el cliente no existe
	    }
	
	
	    public void BorrarId(int id){
		
		    	HisCitaMedica hisCitaMedica=hisCitaMedicaRepositorio.getReferenceById(id);

		    	if(hisCitaMedica != null){

					hisCitaMedica.setEstadoCitaMedica("I");
		    		hisCitaMedica.setFechaEliminacion(LocalDateTime.now());
		    		hisCitaMedicaRepositorio.save(hisCitaMedica);

				}
		}			
		        
	
	
}