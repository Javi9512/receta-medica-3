package com.example.demo.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Receta;
import com.example.demo.repositorio.RecetaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioRecetaImpl implements ServicioReceta {
	
	private final RecetaRepositorio recetaRepositorio;

	@Override
	public List<Receta> listAllReceta() {
		// TODO Auto-generated method stub
		return recetaRepositorio.findAll();
	}

	@Override
	public Receta getReceta(Long id) {
		// TODO Auto-generated method stub
		return recetaRepositorio.findById(id).orElse(null);
	}

	@Override
	public Receta createReceta(Receta receta) {
		// TODO Auto-generated method stub
		receta.setFecha(new Date());
		return recetaRepositorio.save(receta);
	}

	@Override
	public Receta updateReceta(Receta receta) {
		// TODO Auto-generated method stub
		Receta recetabd=getReceta(receta.getId());
		if(recetabd==null) {
			return null;
		}
		recetabd.setFecha(new Date());
		recetabd.setIdMedico(receta.getIdMedico());
		recetabd.setIdPaciente(receta.getIdPaciente());
		return recetaRepositorio.save(recetabd);
		
		
	}

	@Override
	public Receta deleteReceta(Long id) {
		// TODO Auto-generated method stub
		Receta recetabd=getReceta(id);
		if(recetabd==null) {
			return null;
		}
		recetaRepositorio.delete(recetabd);
		return null ;
	}

}
