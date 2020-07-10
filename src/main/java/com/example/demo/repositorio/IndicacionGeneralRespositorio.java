package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.IndicacionGeneral;
import com.example.demo.entidades.Receta;

public interface IndicacionGeneralRespositorio extends JpaRepository<IndicacionGeneral, Long> {
	public List<IndicacionGeneral> findByReceta(Receta receta);
	

}
