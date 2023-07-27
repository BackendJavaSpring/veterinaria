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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.viamatica.veterinaria.modelo.HisConsulta;
import com.viamatica.veterinaria.repositorio.HisConsultaRepositorio;
import com.viamatica.veterinaria.servicio.HisConsultaServicio;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/consulta")
public class HisConsultaControlador {

	
	@Autowired
	HisConsultaServicio hisConsultaServicio;
	
	@Autowired
	HisConsultaRepositorio hisConsultaRepositorio;
	
	

	
	@GetMapping
	 public ResponseEntity<List<HisConsulta>> buscarTodos() {
		 		try {
		 			List<HisConsulta> list1= hisConsultaServicio.obtener();
		 			
		 			if(list1.isEmpty()) {
		 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 			}
		 			
		 			return new ResponseEntity<>(list1 , HttpStatus.OK);
		 		}catch (Exception e) {
		 			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		 		
		 		}
					
		}

	 
	 	@GetMapping("/{citaId}")
        public ResponseEntity <Optional<HisConsulta>> BuscarPorId(@PathVariable ("consultaId") int consultaId){
	 		try {
	 			Optional<HisConsulta> listItem2 =hisConsultaServicio.obtenerPorId(consultaId);
	 			
	 			if(listItem2.isEmpty()) {
	 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	 			}
	 			
	 			return new ResponseEntity<>(listItem2, HttpStatus.OK);
	 		}catch (Exception e) {
	 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	 			
			}
	 		

	 	}




		@PostMapping
	 	public ResponseEntity Guardar(@RequestBody HisConsulta hisConsulta) {
	 		try {
	 			boolean num = hisConsultaServicio.VerificarPorIdDoctor(hisConsulta.getDoctor().getIdDoctor());
	 			
	 			if(num) {
	 				return  new ResponseEntity<>("El registro ya existe" , HttpStatus.BAD_REQUEST);
	 			}
	 			
	 			hisConsultaServicio.Guarda(hisConsulta);
	 			return new ResponseEntity<>(hisConsultaServicio, HttpStatus.OK);
	 		}catch (Exception e) {
	 			return new ResponseEntity<>( e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
	 		
			}
	 		
	 		
	 	}
		
		
		
		
		@PutMapping("{id}")
    	public ResponseEntity<HisConsulta> actualizar(@PathVariable("id") int id, @RequestBody HisConsulta item) {
        Optional<HisConsulta> itemsOpcional = hisConsultaRepositorio.findById(id);
        if (itemsOpcional.isPresent()) {
        	HisConsulta itemExistente = itemsOpcional.get();
        	itemExistente.setConsulta(item.getConsulta());
        	itemExistente.setFechaProgramada(item.getFechaProgramada());
        	itemExistente.setEstadoConsulta(item.getEstadoConsulta());
        	itemExistente.setFechaActualizacion(item.getFechaActualizacion());
            return new ResponseEntity<>(hisConsultaRepositorio.save(itemExistente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

	
 	@DeleteMapping("/{consultaId}")
 	@ResponseBody
 	public ResponseEntity eliminar(@PathVariable ("consultaId") int consultaId) {
 		try {
 			hisConsultaServicio.BorrarId(consultaId);
 			return new ResponseEntity<>(" registro se elimino", HttpStatus.OK);
 			
 		}catch (Exception e) {
 			return new ResponseEntity<>( e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
 		
 		
 	}
 	
	
	
	
}
	
	

