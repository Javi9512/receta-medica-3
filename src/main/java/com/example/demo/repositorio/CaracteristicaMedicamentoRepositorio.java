package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.CaracteristicaMedicamento;

public interface CaracteristicaMedicamentoRepositorio extends JpaRepository<CaracteristicaMedicamento, Long> {
	
}
