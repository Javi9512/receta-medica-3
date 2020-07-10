package com.example.demo.servicio;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entidades.IndicacionGeneral;
import com.example.demo.entidades.Receta;
import com.example.demo.repositorio.IndicacionGeneralRespositorio;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerivcioIndicacionGenralImpl implements ServicioIndicacionGeneral {
	
	private final IndicacionGeneralRespositorio indicacionGeneralRepositorio;

	@Override
	public List<IndicacionGeneral> listAllIndicacionGenerals() {
		
		return indicacionGeneralRepositorio.findAll();
	}

	@Override
	public IndicacionGeneral getIndicacionGeneral(Long id) {
		
		return indicacionGeneralRepositorio.findById(id).orElse(null);
	}

	@Override
	public IndicacionGeneral createIndicacionGeneral(IndicacionGeneral indicacionGeneral) {
		
		return indicacionGeneralRepositorio.save(indicacionGeneral);
	}

	@Override
	public IndicacionGeneral updateIndicacionGeneral(IndicacionGeneral indicacionGeneral) {
		IndicacionGeneral ind=getIndicacionGeneral(indicacionGeneral.getId());
		if(null==ind) {
			return null;
		}
		if(indicacionGeneral.getReceta()!=null) {
			ind.setReceta(indicacionGeneral.getReceta());
		}
		ind.setConcepto(indicacionGeneral.getConcepto());
		return indicacionGeneralRepositorio.save(ind);
		
	}

	@Override
	public IndicacionGeneral deleteIndicacionGeneral(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IndicacionGeneral> findByReceta(Receta receta){
		return indicacionGeneralRepositorio.findByReceta(receta);
	}
}
