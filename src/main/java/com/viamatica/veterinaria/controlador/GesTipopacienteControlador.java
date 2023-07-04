package com.viamatica.veterinaria.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.viamatica.veterinaria.modelo.GesTipopaciente;
import com.viamatica.veterinaria.servicio.GesTipopacienteServicio;

@RestController
public class GesTipopacienteControlador {

	@Autowired
	GesTipopacienteServicio gesTipopacienteServicio;
	 
	public ResponseEntity <List<GesTipopaciente>> buscarTodos(){
				try {
					
					List<GesTipopaciente> Numeral = gesTipopacienteServicio.obtener();
					
					if(Numeral.isEmpty()) {
						
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						
					}	
					
				  return new ResponseEntity<>(Numeral, HttpStatus.OK);
				  
				}
				catch (Exception e) {
					
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		
		
	} 
	
	
	public ResponseEntity<Optional<GesTipopaciente>> buscarPorId(@PathVariable("idTipopaciente")int idTipopaciente){
		
				try {
					
					Optional<GesTipopaciente> Numeral2 =gesTipopacienteServicio.obtenerPorId(idTipopaciente);
					
					if(Numeral2.isEmpty()) {
						
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						
					}
					
					return new ResponseEntity<>(Numeral2, HttpStatus.OK);
					
					
				}
				catch (Exception e) {
					
					
					return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
					
				}
		
		
		
	}
	
	
	
	
}
