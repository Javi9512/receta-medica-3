package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Proveedor;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {

}
