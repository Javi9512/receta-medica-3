package com.example.demo.servicio;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Fabricante;
import com.example.demo.repositorio.FabricanteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioFabricanteImpl implements ServicioFabricante {

	private final FabricanteRepositorio fabricanteRepositorio;

	@Override
	public List<Fabricante> listAllFabricante() {
		// TODO Auto-generated method stub
		return fabricanteRepositorio.findAll();
	}

	@Override
	public Fabricante getFabricante(Long id) {
		// TODO Auto-generated method stub
		return fabricanteRepositorio.findById(id).orElse(null);
	}

	@Override
	public Fabricante createFabricante(Fabricante fabricante) {
		// TODO Auto-generated method stub
		return fabricanteRepositorio.save(fabricante);
	}

	@Override
	public Fabricante updateFabricante(Fabricante fabricante) {
		// TODO Auto-generated method stub
		Fabricante fabricantebd=getFabricante(fabricante.getId());
		if(fabricantebd==null) {
			return null;
		}
				
		return fabricanteRepositorio.save(fabricante);
		
		
	}

	@Override
	public Fabricante deleteFabricante(Long id) {
		// TODO Auto-generated method stub
		Fabricante fabricantebd=getFabricante(id);
		if(fabricantebd==null) {
			return null;
		}
		fabricanteRepositorio.delete(fabricantebd);
		return null ;
	}
	
}
