package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Enfermedad;

public interface ServicioEnfermedad {

public List<Enfermedad> listAllEnfermedad();
	
	public Enfermedad getEnfermedad(Long id);
	
	public Enfermedad createEnfermedad(Enfermedad enfermedad);
	
	public Enfermedad updateEnfermedad(Enfermedad enfermedad);
	
	public Enfermedad deleteEnfermedad(Long id);
}
