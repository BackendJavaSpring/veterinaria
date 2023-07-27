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
import com.viamatica.veterinaria.modelo.HisDoctor;
import com.viamatica.veterinaria.repositorio.HisDoctorRepositorio;
import com.viamatica.veterinaria.servicio.HisDoctorServicio;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/doctor")
public class HisDoctorControlador {

	@Autowired
	HisDoctorServicio hisDoctorServicio;

	@Autowired
	HisDoctorRepositorio hisDoctorRepositorio;

	@GetMapping("/buscarTodos")
	@ResponseBody
	public ResponseEntity<List<HisDoctor>> BuscarTodos() {

		try {

			List<HisDoctor> listItem = hisDoctorServicio.ObtenerListado();

			if (listItem.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(listItem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{doctorId}")
	@ResponseBody
	public ResponseEntity<Optional<HisDoctor>> BuscarPorId(@PathVariable("doctorId") int doctorId) {
		try {
			Optional<HisDoctor> listItem2 = hisDoctorServicio.ObtenerId(doctorId);

			if (listItem2.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}

			return new ResponseEntity<>(listItem2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/Guardar")
	@ResponseBody
	public ResponseEntity Guardar(@RequestBody HisDoctor hisDoctor) {

		try {

			boolean cedulaExistente = hisDoctorServicio.VerificarExistenciaCedula(hisDoctor.getCedula());
			if (cedulaExistente) {
				return new ResponseEntity<>("El registro ya existe.", HttpStatus.BAD_REQUEST);
			}

			hisDoctorServicio.Guarda(hisDoctor);
			return new ResponseEntity<>(hisDoctorServicio, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("{id}")
	public ResponseEntity<HisDoctor> actualizar(@PathVariable("id") int id, @RequestBody HisDoctor item) {
		Optional<HisDoctor> itemsOpcional = hisDoctorRepositorio.findById(id);
		if (itemsOpcional.isPresent()) {
			HisDoctor itemExistente = itemsOpcional.get();
			itemExistente.setEstadoDoctor(item.getEstadoDoctor());
			itemExistente.setFechaActualizacion(item.getFechaActualizacion());
			itemExistente.setCedula(item.getCedula());
			itemExistente.setNombre(item.getNombre());
			itemExistente.setEdad(item.getEdad());
			itemExistente.setEspecialidad(item.getEspecialidad());
			itemExistente.setTelefono(item.getTelefono());
			itemExistente.setSegUsuario(item.getSegUsuario());

			return new ResponseEntity<>(hisDoctorRepositorio.save(itemExistente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{doctorId}")
	@ResponseBody
	public ResponseEntity elimina(@PathVariable("doctorId") int doctorId) {
		try {
			hisDoctorServicio.eliminar(doctorId);

			return new ResponseEntity<>("registro eliminado", HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}