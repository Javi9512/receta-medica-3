package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Enfermedad;
import com.example.demo.repositorio.EnfermedadRepositorio;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioEnfermedadImpl implements ServicioEnfermedad{
	private final EnfermedadRepositorio enfermedadRepositorio;

	@Override
	public List<Enfermedad> listAllEnfermedad() {
		// TODO Auto-generated method stub
		return enfermedadRepositorio.findAll();
	}

	@Override
	public Enfermedad getEnfermedad(Long id) {
		// TODO Auto-generated method stub
		return enfermedadRepositorio.findById(id).orElse(null);
	}

	@Override
	public Enfermedad createEnfermedad(Enfermedad enfermedad) {
		// TODO Auto-generated method stub

		return enfermedadRepositorio.save(enfermedad);
	}

	@Override
	public Enfermedad updateEnfermedad(Enfermedad enfermedad) {
		// TODO Auto-generated method stub
		Enfermedad enfermedadbd=getEnfermedad(enfermedad.getId());
		if(enfermedadbd==null) {
			return null;
		}
		
		return enfermedadRepositorio.save(enfermedad);
		
		
	}

	@Override
	public Enfermedad deleteEnfermedad(Long id) {
		// TODO Auto-generated method stub
		Enfermedad enfermedadbd=getEnfermedad(id);
		if(enfermedadbd==null) {
			return null;
		}
		enfermedadRepositorio.delete(enfermedadbd);
		return null ;
	}
}
