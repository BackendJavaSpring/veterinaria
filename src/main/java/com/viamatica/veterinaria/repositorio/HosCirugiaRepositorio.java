
package com.viamatica.veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viamatica.veterinaria.modelo.HosCirugia;

@Repository
public interface HosCirugiaRepositorio extends JpaRepository<HosCirugia, Integer>{
    

}