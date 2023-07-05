package com.viamatica.veterinaria.controlador;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viamatica.veterinaria.modelo.GesCliente;
import com.viamatica.veterinaria.servicio.GesClienteServicio;


@RestController
@RequestMapping("/GesCliente")
public class GesClienteControlador {

	@Autowired
	GesClienteServicio   gesClienteServicio;

	@GetMapping
	public ResponseEntity<List<GesCliente>> obtenerTodos() {

				try {
		
					List<GesCliente> items = gesClienteServicio.obtener();
		
					if (items.isEmpty()) {
		
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
					}
		
					return new ResponseEntity<>(items, HttpStatus.OK);
				} catch (Exception e) {
		
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
	}
	
	
	
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Optional<GesCliente>> obtenerPorId(@PathVariable ("clienteId") int clienteId){
		
		
					try {
						
						Optional<GesCliente> listNum= gesClienteServicio.ObtenerId(clienteId);
						
						if(listNum.isEmpty()) {
							
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
							
						}
						
						return new ResponseEntity<>(listNum, HttpStatus.OK);
					}
					catch (Exception e) {
						
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
						
					 }
		
			}
	
	

	}






