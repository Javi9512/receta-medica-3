package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Proveedor;

public interface ServicioProveedor {

public List<Proveedor> listAllProveedor();
	
	public Proveedor getProveedor(Long id);
	
	public Proveedor createProveedor(Proveedor proveedor);
	
	public Proveedor updateProveedor(Proveedor proveedor);
	
	public void deleteProveedor(Long id);
	
}
