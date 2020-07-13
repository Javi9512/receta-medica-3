package com.example.demo.servicio;



import java.util.List;

import com.example.demo.entidades.IndicacionGeneral;
import com.example.demo.entidades.Receta;



public interface ServicioIndicacionGeneral {
	public List<IndicacionGeneral> listAllIndicacionGenerals();
	public IndicacionGeneral getIndicacionGeneral(Long id);
	public IndicacionGeneral createIndicacionGeneral(IndicacionGeneral indicacionGeneral);
    public IndicacionGeneral updateIndicacionGeneral(IndicacionGeneral indicacionGeneral);
    public void deleteIndicacionGeneral(Long id);
    public List<IndicacionGeneral> findByReceta(Receta receta);

}
