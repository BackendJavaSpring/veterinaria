package com.viamatica.veterinaria.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.viamatica.veterinaria.modelo.GesPaciente;
import com.viamatica.veterinaria.servicio.GesPacienteServicio;


@RestController
public class GesPacienteControlador {

	@Autowired
	GesPacienteServicio gesPacienteServicio;
	
	
	public ResponseEntity<List<GesPaciente>> obtenerTodos(){
		
				try {
					
					List<GesPaciente> items = gesPacienteServicio.obtener();
					
					if(items.isEmpty()) {
						
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					}
					
					return new ResponseEntity<>(items, HttpStatus.OK);
				}
				catch (Exception e) {
					
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);				
				}
		
	}
	
	
	
	public ResponseEntity<Optional<GesPaciente>> obtenerPorId(@PathVariable ("idPaciente") int idPaciente){
		
				try {
					
					Optional<GesPaciente> item2=gesPacienteServicio.obtenerPorId(idPaciente);
					
					if(item2.isEmpty()) {
						
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						
					}
					
					return new ResponseEntity<>(item2, HttpStatus.OK);
					
				}
				catch (Exception e) {
					
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		
		
	}
	
	
	
	
	
	
	
}
