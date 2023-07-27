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
import com.viamatica.veterinaria.modelo.HisHistoriaClinica;
import com.viamatica.veterinaria.repositorio.HisHistoriaClinicaRepositorio;
import com.viamatica.veterinaria.servicio.HisHistoriaClinicaServicio;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/historiaClinica")
public class HisHistoriaClinicaControlador {

			@Autowired
			HisHistoriaClinicaServicio hisHistoriaClinicaServicio;
			
			@Autowired
			HisHistoriaClinicaRepositorio hisHistoriaClinicaRepositorio;
			
			
			@GetMapping
			public ResponseEntity<List<HisHistoriaClinica>> buscarTodos(){
					try {
						List<HisHistoriaClinica> listitem = hisHistoriaClinicaServicio.ObtenerListado();
						if(listitem.isEmpty()) {
			 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 			}
						return new ResponseEntity<>(listitem, HttpStatus.OK);
						
					}catch (Exception e) {
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
						
					}
				
					
			}
	
			
			@GetMapping("/{hisHistoriaClinicaId}")
			  public ResponseEntity <Optional<HisHistoriaClinica>> BuscarPorId(@PathVariable ("hisHistoriaClinicaId") int hisHistoriaClinicaId){
		 		try {
		 			Optional<HisHistoriaClinica> listItem2 =hisHistoriaClinicaServicio.ObtenerId(hisHistoriaClinicaId);
		 			
		 			if(listItem2.isEmpty()) {
		 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
		 			}
		 			
		 			return new ResponseEntity<>(listItem2, HttpStatus.OK);
		 		}catch (Exception e) {
		 			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 			
				}
		 		

		 	}
		 
		 
		 	@PostMapping
		 	public ResponseEntity Guardar(@RequestBody HisHistoriaClinica hisHistoriaClinica) {
		 		try {
		 			boolean num = hisHistoriaClinicaServicio.VerificarIdPaciente(hisHistoriaClinica.getGesPaciente().getIdPaciente());
		 			
		 			if(num) {
		 				return  new ResponseEntity<>("El registro ya existe" , HttpStatus.BAD_REQUEST);
		 			}
		 			
		 			hisHistoriaClinicaServicio.Guarda(hisHistoriaClinica);
		 			return new ResponseEntity<>(hisHistoriaClinicaServicio, HttpStatus.OK);
		 		}catch (Exception e) {
		 			return new ResponseEntity<>( e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		 		
				}
		 		
		 		
		 	}
		 	
		 	 	
		 	
		 	
		 	@DeleteMapping("/{hisHistoriaClinicaId}")
		 	public ResponseEntity eliminarPorId(@PathVariable ("hisHistoriaClinicaId") int hisHistoriaClinicaId) {
		 		try {
		 			hisHistoriaClinicaServicio.BorrarId(hisHistoriaClinicaId);
		 			return new ResponseEntity<>(" Registro eliminado ",HttpStatus.OK);
		 			
		 		}catch (Exception e) {
		 			return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		 			
				}
		 		
		 	}
		 
		 	
		 	
		 	@PutMapping("{id}")
        	public ResponseEntity<HisHistoriaClinica> actualizar(@PathVariable("id") int id, @RequestBody HisHistoriaClinica item) {
            Optional<HisHistoriaClinica> itemsOpcional = hisHistoriaClinicaRepositorio.findById(id);
            if (itemsOpcional.isPresent()) {
                HisHistoriaClinica itemExistente = itemsOpcional.get();
				
                itemExistente.setGesCliente(item.getGesCliente());
                itemExistente.setEstadoHistoriaClinica(item.getEstadoHistoriaClinica());
                itemExistente.setFechaActualizacion(item.getFechaActualizacion());
                
                return new ResponseEntity<>(hisHistoriaClinicaRepositorio.save(itemExistente), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	
	
	
	
	
	
	
	
}










