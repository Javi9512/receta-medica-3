package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.IndicacionGeneral;
import com.example.demo.entidades.IndicacionMedicamento;
import com.example.demo.entidades.Receta;

public interface IndicacionMedicamentoRepositorio extends JpaRepository<IndicacionMedicamento, Long> {
	public List<IndicacionMedicamento> findByReceta(Receta receta);

}
