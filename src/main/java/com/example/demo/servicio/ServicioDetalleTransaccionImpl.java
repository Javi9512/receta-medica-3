package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.DetalleTransaccion;
import com.example.demo.repositorio.DetalleTransaccionRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioDetalleTransaccionImpl implements ServicioDetalleTransaccion {
	private final DetalleTransaccionRepositorio detalleTransaccionRepositorio;

	@Override
	public List<DetalleTransaccion> listAllDetalleTransaccion() {
		// TODO Auto-generated method stub
		return detalleTransaccionRepositorio.findAll();
	}

	@Override
	public DetalleTransaccion getDetalleTransaccion(Long id) {
		// TODO Auto-generated method stub
		return detalleTransaccionRepositorio.findById(id).orElse(null);
	}

	@Override
	public DetalleTransaccion createDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
		// TODO Auto-generated method stub
	
		return detalleTransaccionRepositorio.save(detalleTransaccion);
	}

	@Override
	public DetalleTransaccion updateDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
		// TODO Auto-generated method stub
		DetalleTransaccion detalleTransaccionbd=getDetalleTransaccion(detalleTransaccion.getId());
		if(detalleTransaccionbd==null) {
			return null;
		}

		return detalleTransaccionRepositorio.save(detalleTransaccion);
		
		
	}

	@Override
	public DetalleTransaccion deleteDetalleTransaccion(Long id) {
		// TODO Auto-generated method stub
		DetalleTransaccion detalleTransaccionbd=getDetalleTransaccion(id);
		if(detalleTransaccionbd==null) {
			return null;
		}
		detalleTransaccionRepositorio.delete(detalleTransaccionbd);
		return null ;
	}
}
