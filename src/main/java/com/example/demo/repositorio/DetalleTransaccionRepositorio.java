package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.DetalleTransaccion;

public interface DetalleTransaccionRepositorio extends JpaRepository<DetalleTransaccion, Long> {

}
