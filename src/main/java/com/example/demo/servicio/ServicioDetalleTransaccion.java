package com.example.demo.servicio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.DetalleTransaccion;


public interface ServicioDetalleTransaccion {
	public List<DetalleTransaccion> listAllDetalleTransaccion();
	
	public DetalleTransaccion getDetalleTransaccion(Long id);
	
	public DetalleTransaccion createDetalleTransaccion(DetalleTransaccion detalleTransaccion);
	
	public DetalleTransaccion updateDetalleTransaccion(DetalleTransaccion detalleTransaccion);
	
	public DetalleTransaccion deleteDetalleTransaccion(Long id);
}
