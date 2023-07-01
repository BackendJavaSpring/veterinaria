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

import com.viamatica.veterinaria.modelo.HosRevisionDiaria;
import com.viamatica.veterinaria.repositorio.HosRevisionDiariaRepositorio;

@RestController
@RequestMapping("/HosRevisionDiaria")
class HosRevisionDiariaControlador {

    @Autowired
    HosRevisionDiariaRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<HosRevisionDiaria>> obtenerTodos() {
        try {
            List<HosRevisionDiaria> items = new ArrayList<HosRevisionDiaria>();

            repositorio.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<HosRevisionDiaria> obtenerPorId(@PathVariable("id") Integer id) {
        Optional<HosRevisionDiaria> itemOpcional = repositorio.findById(id);

        if (itemOpcional.isPresent()) {
            return new ResponseEntity<>(itemOpcional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HosRevisionDiaria> crear(@RequestBody HosRevisionDiaria item) {
        try {
            HosRevisionDiaria itemSalvado = repositorio.save(item);
            return new ResponseEntity<>(itemSalvado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<HosRevisionDiaria> actualizar(@PathVariable("id") Integer id, @RequestBody HosRevisionDiaria item) {
        Optional<HosRevisionDiaria> itemOpcional = repositorio.findById(id);
        if (itemOpcional.isPresent()) {
            HosRevisionDiaria itemExistente = itemOpcional.get();
            itemExistente.setFechaActulizacion(new Date());
            itemExistente.setFechaRevision(item.getFechaRevision());
            itemExistente.setIdPaciente(item.getIdPaciente());
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