package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Fabricante;

public interface ServicioFabricante {

	public List<Fabricante> listAllFabricante();
	
	public Fabricante getFabricante(Long id);
	
	public Fabricante createFabricante(Fabricante Fabricante);
	
	public Fabricante updateFabricante(Fabricante Fabricante);
	
	public void deleteFabricante(Long id);
}
