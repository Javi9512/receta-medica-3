package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Transaccion;

public interface ServicioTransaccion {
public List<Transaccion> listAllTransaccion();
	
	public Transaccion getTransaccion(Long id);
	
	public Transaccion createTransaccion(Transaccion transaccion);
	
	public Transaccion updateTransaccion(Transaccion transaccion);
	
	public Transaccion deleteTransaccion(Long id);
}
