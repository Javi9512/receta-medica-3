package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.FormaFarmaceutica;



public interface ServicioFormaFarmaceutica {
	
	public List<FormaFarmaceutica> listAllFormaFarmaceutica();
	
	public FormaFarmaceutica getFormaFarmaceutica(Long id);
	
	public FormaFarmaceutica createFormaFarmaceutica(FormaFarmaceutica FormaFarmaceutica);
	
	public FormaFarmaceutica updateFormaFarmaceutica(FormaFarmaceutica FormaFarmaceutica);
	
	public void deleteFormaFarmaceutica(Long id);
}
