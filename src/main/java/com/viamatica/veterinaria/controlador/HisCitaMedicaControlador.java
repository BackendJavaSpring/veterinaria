package com.viamatica.veterinaria.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viamatica.veterinaria.modelo.HisCitaMedica;
import com.viamatica.veterinaria.repositorio.HisCitaMedicaRepositorio;
import com.viamatica.veterinaria.servicio.HisCitaMedicaServicio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/citaMedica")
public class HisCitaMedicaControlador {
	
		@Autowired
		HisCitaMedicaServicio hiscitaMedicaServicio;

		@Autowired
		HisCitaMedicaRepositorio hisCitaMedicaRepositorio;

		
		
		@GetMapping("/buscarTodos")
		 public ResponseEntity<List<HisCitaMedica>> buscarTodos() {
			 		try {
			 			List<HisCitaMedica> list1= hiscitaMedicaServicio.ObtenerListado();
			 			
			 			if(list1.isEmpty()) {
			 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 			}
			 			
			 			return new ResponseEntity<>(list1 , HttpStatus.OK);
			 		}catch (Exception e) {
			 			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
			 		
			 		}
						
			}

		 
		 	@GetMapping("/{citaId}")
	        public ResponseEntity <Optional<HisCitaMedica>> BuscarPorId(@PathVariable ("citaId") int citaId){
		 		try {
		 			Optional<HisCitaMedica> listItem2 =hiscitaMedicaServicio.ObtenerId(citaId);
		 			
		 			if(listItem2.isEmpty()) {
		 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
		 			}
		 			
		 			return new ResponseEntity<>(listItem2, HttpStatus.OK);
		 		}catch (Exception e) {
		 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 			
				}
		 		

		 	}
		 
		 
		 	@PostMapping("/Guardar")
		 	public ResponseEntity Guardar(@RequestBody HisCitaMedica hisCitaMedica) {
		 		try {
		 			boolean num = hiscitaMedicaServicio.VerificarIdPaciente(hisCitaMedica.getGesPaciente().getIdPaciente());
		 			
		 			if(num) {
		 				return  new ResponseEntity<>("El registro ya existe" , HttpStatus.BAD_REQUEST);
		 			}
		 			
		 			hiscitaMedicaServicio.Guarda(hisCitaMedica);
		 			return new ResponseEntity<>(hiscitaMedicaServicio, HttpStatus.OK);
		 		}catch (Exception e) {
		 			return new ResponseEntity<>( e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		 		
				}
		 		
		 		
		 	}
		 	
		 	 	
		 	
		 	
		 	@DeleteMapping("/{citaMedicaId}")
		 	public ResponseEntity eliminarPorId(@PathVariable ("citaMedicaId") int citaMedicaId) {
		 		try {
		 			hiscitaMedicaServicio.BorrarId(citaMedicaId);
		 			return new ResponseEntity<>(" Registro eliminado ",HttpStatus.OK);
		 			
		 		}catch (Exception e) {
		 			return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		 			
				}
		 		
		 	}
		 
		 	
		 	
		 	@PutMapping("{id}")
        	public ResponseEntity<HisCitaMedica> actualizar(@PathVariable("id") int id, @RequestBody HisCitaMedica item) {
            Optional<HisCitaMedica> itemsOpcional = hisCitaMedicaRepositorio.findById(id);
            if (itemsOpcional.isPresent()) {
                HisCitaMedica itemExistente = itemsOpcional.get();
				itemExistente.setDescripcionCitaMedica(item.getDescripcionCitaMedica());
				itemExistente.setFechaCita(item.getFechaCita());
				itemExistente.setEstadoCitaMedica(item.getEstadoCitaMedica());
				itemExistente.setFechaActualizacion(item.getFechaActualizacion());
				itemExistente.setGesPaciente(item.getGesPaciente());
				itemExistente.setHisDoctor(item.getHisDoctor());
			
                return new ResponseEntity<>(hisCitaMedicaRepositorio.save(itemExistente), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		
		 
		 
		 
		 
		
		
		
	
	
	
}
