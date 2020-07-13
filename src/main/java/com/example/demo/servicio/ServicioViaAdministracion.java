package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.ViaAdministracion;



public interface ServicioViaAdministracion {

	public List<ViaAdministracion> listAllViaAdministracion();
	
	public ViaAdministracion getViaAdministracion(Long id);
	
	public ViaAdministracion createViaAdministracion(ViaAdministracion ViaAdministracion);
	
	public ViaAdministracion updateViaAdministracion(ViaAdministracion ViaAdministracion);
	
	public void deleteViaAdministracion(Long id);
}
