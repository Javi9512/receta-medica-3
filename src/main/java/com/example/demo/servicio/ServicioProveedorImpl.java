package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Proveedor;
import com.example.demo.repositorio.ProveedorRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioProveedorImpl implements ServicioProveedor{
	
	private final ProveedorRepositorio proveedorRepositorio;

	@Override
	public List<Proveedor> listAllProveedor() {
		// TODO Auto-generated method stub
		return proveedorRepositorio.findAll();
	}

	@Override
	public Proveedor getProveedor(Long id) {
		// TODO Auto-generated method stub
		return proveedorRepositorio.findById(id).orElse(null);
	}

	@Override
	public Proveedor createProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
	
		return proveedorRepositorio.save(proveedor);
	}

	@Override
	public Proveedor updateProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		Proveedor proveedorbd=getProveedor(proveedor.getId());
		if(proveedorbd==null) {
			return null;
		}

		return proveedorRepositorio.save(proveedor);
		
		
	}

	@Override
	public void deleteProveedor(Long id) {
		// TODO Auto-generated method stub
		Proveedor proveedorbd=getProveedor(id);
		if(proveedorbd==null) {
			return;
		}
		proveedorRepositorio.delete(proveedorbd);
	}
}
