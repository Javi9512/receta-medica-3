package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Receta;



public interface ServicioReceta {
	
	public List<Receta> listAllReceta();
	
	public Receta getReceta(Long id);
	
	public Receta createReceta(Receta receta);
	
	public Receta updateReceta(Receta receta);
	
	public Receta deleteReceta(Long id);
	


}
