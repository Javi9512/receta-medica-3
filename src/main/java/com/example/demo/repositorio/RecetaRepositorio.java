package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Receta;

public interface RecetaRepositorio extends JpaRepository<Receta, Long>{

}
