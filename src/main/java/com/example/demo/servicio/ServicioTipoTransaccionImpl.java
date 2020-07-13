package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.TipoTransaccion;
import com.example.demo.repositorio.TipoTransaccionRepositorio;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ServicioTipoTransaccionImpl implements ServicioTipoTransaccion{
	private final TipoTransaccionRepositorio tipoTipoTransaccionRepositorio;

	@Override
	public List<TipoTransaccion> listAllTipoTransaccion() {
		// TODO Auto-generated method stub
		return tipoTipoTransaccionRepositorio.findAll();
	}

	@Override
	public TipoTransaccion getTipoTransaccion(Long id) {
		// TODO Auto-generated method stub
		return tipoTipoTransaccionRepositorio.findById(id).orElse(null);
	}

	@Override
	public TipoTransaccion createTipoTransaccion(TipoTransaccion tipoTipoTransaccion) {
		// TODO Auto-generated method stub
	
		return tipoTipoTransaccionRepositorio.save(tipoTipoTransaccion);
	}

	@Override
	public TipoTransaccion updateTipoTransaccion(TipoTransaccion tipoTipoTransaccion) {
		// TODO Auto-generated method stub
		TipoTransaccion tipoTipoTransaccionbd=getTipoTransaccion(tipoTipoTransaccion.getId());
		if(tipoTipoTransaccionbd==null) {
			return null;
		}

		return tipoTipoTransaccionRepositorio.save(tipoTipoTransaccion);
		
		
	}

	@Override
	public void deleteTipoTransaccion(Long id) {
		// TODO Auto-generated method stub
		TipoTransaccion tipoTipoTransaccionbd=getTipoTransaccion(id);
		if(tipoTipoTransaccionbd==null) {
			return;
		}
		tipoTipoTransaccionRepositorio.delete(tipoTipoTransaccionbd);
	}
}
