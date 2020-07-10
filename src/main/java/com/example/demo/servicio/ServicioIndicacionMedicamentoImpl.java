package com.example.demo.servicio;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.demo.entidades.IndicacionMedicamento;
import com.example.demo.entidades.Receta;
import com.example.demo.repositorio.IndicacionMedicamentoRepositorio;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioIndicacionMedicamentoImpl implements ServicioIndicacionMedicamento{
	
	private final IndicacionMedicamentoRepositorio indicacionMedicamentoRepositorio;
	
	@Override
	public List<IndicacionMedicamento> listAllIndicacionMedicamentos(){
		return indicacionMedicamentoRepositorio.findAll();
	}

	@Override
	public IndicacionMedicamento getIndicacionMedicamento(Long id) {

		return indicacionMedicamentoRepositorio.findById(id).orElse(null);
	}

	@Override
	public IndicacionMedicamento createIndicacionGeneral(IndicacionMedicamento indicacionMedicamento) {
		
		return indicacionMedicamentoRepositorio.save(indicacionMedicamento);
	}

	@Override
	public IndicacionMedicamento updateIndicacionMedicamento(IndicacionMedicamento indicacionMedicamento) {
		IndicacionMedicamento indicacion=getIndicacionMedicamento(indicacionMedicamento.getId());
		if(indicacion==null) {
		return null;
		}
		indicacion.setDiasTratamiento(indicacionMedicamento.getDiasTratamiento());
		indicacion.setDosis(indicacionMedicamento.getDosis());
		indicacion.setFrecuencia(indicacionMedicamento.getFrecuencia());
		indicacion.setReceta(indicacionMedicamento.getReceta());
		return indicacionMedicamentoRepositorio.save(indicacion);
	}

	@Override
	public IndicacionMedicamento deleteIndicacionMedicamento(Long id) {
		
		return null;
	}
	
	@Override
	public List<IndicacionMedicamento> findByReceta(Receta receta){
		return indicacionMedicamentoRepositorio.findByReceta(receta);
	}

}
