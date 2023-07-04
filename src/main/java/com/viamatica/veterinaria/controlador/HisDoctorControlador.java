package com.viamatica.veterinaria.controlador;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viamatica.veterinaria.modelo.HisDoctor;
import com.viamatica.veterinaria.servicio.HisDoctorServicio;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/doctor")
public class HisDoctorControlador {
    
	@Autowired
	HisDoctorServicio hisDoctorServicio;


        @GetMapping
        public ResponseEntity<List<HisDoctor>>  BuscarTodos() {
        	
		            try {
		            	
		               List<HisDoctor> listItem = hisDoctorServicio.ObtenerListado();
		               
		               if(listItem.isEmpty()) {
		            	   
		            	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		               }
		               
		               return new ResponseEntity<>(listItem, HttpStatus.OK);
		               
		            } 
		            catch (Exception e) {
		            	
		            	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		            }
            
        }
        
        

        @GetMapping("/{doctorId}")
        public ResponseEntity <Optional<HisDoctor>> BuscarPorId(@PathVariable ("doctorId") int doctorId){
		        	try {
		        		Optional<HisDoctor> listItem2 =hisDoctorServicio.ObtenerId(doctorId);
		        		
		        		if(listItem2.isEmpty()) {
		        			
		        			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		        			
		        		}
		        		
		        		return new ResponseEntity<>(listItem2, HttpStatus.OK);
		        	}catch (Exception e) {
		        		
		        		
		        		return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
					}

            
        }
        

        @PostMapping
        public ResponseEntity GuardarActualizar(@RequestBody HisDoctor hisDoctor){
        	
		        	try {
		    
		        		 hisDoctorServicio.GuardaActualiza(hisDoctor);
		        		 return new ResponseEntity<>( HttpStatus.OK);
		        	}
		        	catch (Exception e) {	        	
					log.error(e.getMessage());
		        		return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
					}
           

        }


        @DeleteMapping("/{doctorId}")
        public ResponseEntity eliminarPorId (@PathVariable ("doctorId") int doctorId){
		        	try {
		        		hisDoctorServicio.BorrarId(doctorId);
		        		
		        		return ResponseEntity.ok().build();
		        		
		        	}catch (Exception e) {
		        		
		        		return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		        		
					}


        }





}