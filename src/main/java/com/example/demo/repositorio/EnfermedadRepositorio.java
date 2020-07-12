package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Enfermedad;

public interface EnfermedadRepositorio extends JpaRepository<Enfermedad, Long> {

}
