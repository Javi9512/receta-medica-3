package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.ViaAdministracion;
import com.example.demo.repositorio.ViaAdministracionRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioViaAdministracionImpl implements ServicioViaAdministracion{

	private final ViaAdministracionRepositorio viaAdministracionRepositorio;

	@Override
	public List<ViaAdministracion> listAllViaAdministracion() {
		// TODO Auto-generated method stub
		return viaAdministracionRepositorio.findAll();
	}

	@Override
	public ViaAdministracion getViaAdministracion(Long id) {
		// TODO Auto-generated method stub
		return viaAdministracionRepositorio.findById(id).orElse(null);
	}

	@Override
	public ViaAdministracion createViaAdministracion(ViaAdministracion ViaAdministracion) {
		// TODO Auto-generated method stub
		return viaAdministracionRepositorio.save(ViaAdministracion);
	}

	@Override
	public ViaAdministracion updateViaAdministracion(ViaAdministracion viaAdministracion) {
		// TODO Auto-generated method stub
		ViaAdministracion viaAdministracionbd=getViaAdministracion(viaAdministracion.getId());
		if(viaAdministracionbd==null) {
			return null;
		}
		viaAdministracionbd.setNombre(viaAdministracion.getNombre());
		return viaAdministracionRepositorio.save(viaAdministracionbd);
		
		
	}

	@Override
	public ViaAdministracion deleteViaAdministracion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
