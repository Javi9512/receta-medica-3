package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Transaccion;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long>{

}
