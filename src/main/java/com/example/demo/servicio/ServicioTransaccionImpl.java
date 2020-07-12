package com.example.demo.servicio;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Transaccion;

import com.example.demo.repositorio.TransaccionRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioTransaccionImpl implements ServicioTransaccion{

	private final TransaccionRepositorio transaccionRepositorio;

	@Override
	public List<Transaccion> listAllTransaccion() {
		// TODO Auto-generated method stub
		return transaccionRepositorio.findAll();
	}

	@Override
	public Transaccion getTransaccion(Long id) {
		// TODO Auto-generated method stub
		return transaccionRepositorio.findById(id).orElse(null);
	}

	@Override
	public Transaccion createTransaccion(Transaccion transaccion) {
		// TODO Auto-generated method stub
	
		return transaccionRepositorio.save(transaccion);
	}

	@Override
	public Transaccion updateTransaccion(Transaccion transaccion) {
		// TODO Auto-generated method stub
		Transaccion transaccionbd=getTransaccion(transaccion.getId());
		if(transaccionbd==null) {
			return null;
		}

		return transaccionRepositorio.save(transaccion);
		
		
	}

	@Override
	public Transaccion deleteTransaccion(Long id) {
		// TODO Auto-generated method stub
		Transaccion transaccionbd=getTransaccion(id);
		if(transaccionbd==null) {
			return null;
		}
		transaccionRepositorio.delete(transaccionbd);
		return null ;
	}
}
