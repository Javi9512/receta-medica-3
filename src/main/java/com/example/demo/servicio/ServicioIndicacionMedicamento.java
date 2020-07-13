package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.IndicacionMedicamento;
import com.example.demo.entidades.Receta;

public interface ServicioIndicacionMedicamento {
	public List<IndicacionMedicamento> listAllIndicacionMedicamentos();
	public IndicacionMedicamento getIndicacionMedicamento(Long id);
	public IndicacionMedicamento createIndicacionGeneral(IndicacionMedicamento indicacionMedicamento);
	public IndicacionMedicamento updateIndicacionMedicamento(IndicacionMedicamento indicacionMedicamento);
	public void deleteIndicacionMedicamento(Long id);
	public List<IndicacionMedicamento> findByReceta(Receta receta);
}
