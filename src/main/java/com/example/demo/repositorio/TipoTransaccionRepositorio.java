package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.TipoTransaccion;

public interface TipoTransaccionRepositorio extends JpaRepository<TipoTransaccion, Long> {

}
