package com.viamatica.veterinaria.controlador;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viamatica.veterinaria.modelo.HosHospitalizacionPaciente;
import com.viamatica.veterinaria.repositorio.HosHospitalizacionPacienteRepositorio;

@RestController
@RequestMapping("/HosHospitalizacionPaciente")
class HosHospitalizacionPacienteControlador {

    @Autowired
    HosHospitalizacionPacienteRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<HosHospitalizacionPaciente>> obtenerTodos() {
        try {
            List<HosHospitalizacionPaciente> items = new ArrayList<HosHospitalizacionPaciente>();

            repositorio.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<HosHospitalizacionPaciente> obtenerPorId(@PathVariable("id") Integer id) {
        Optional<HosHospitalizacionPaciente> itemOpcional = repositorio.findById(id);

        if (itemOpcional.isPresent()) {
            return new ResponseEntity<>(itemOpcional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HosHospitalizacionPaciente> crear(@RequestBody HosHospitalizacionPaciente item) {
        try {
            HosHospitalizacionPaciente itemSalvado = repositorio.save(item);
            return new ResponseEntity<>(itemSalvado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<HosHospitalizacionPaciente> actualizar(@PathVariable("id") Integer id, @RequestBody HosHospitalizacionPaciente item) {
        Optional<HosHospitalizacionPaciente> itemOpcional = repositorio.findById(id);
        if (itemOpcional.isPresent()) {
            HosHospitalizacionPaciente itemExistente = itemOpcional.get();
            itemExistente.setFechaActualizacion(new Date());
            itemExistente.setFechaIngreso(item.getFechaIngreso());
            itemExistente.setFechaSalida(item.getFechaSalida());
            itemExistente.setMotivo(item.getMotivo());
            return new ResponseEntity<>(repositorio.save(itemExistente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> borrar(@PathVariable("id") Integer id) {
        try {
            repositorio.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}