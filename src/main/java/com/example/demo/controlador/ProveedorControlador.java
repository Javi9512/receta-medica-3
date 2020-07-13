package com.example.demo.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Proveedor;
import com.example.demo.servicio.ServicioProveedor;

@RestController
@RequestMapping(value="/proveedores")
public class ProveedorControlador {
	@Autowired
	private ServicioProveedor servicioProveedor;
	
	@GetMapping
	public ResponseEntity<List<Proveedor>> listarProveedor(){
		List<Proveedor> proveedors=servicioProveedor.listAllProveedor();
		if(proveedors.isEmpty()) {
			System.out.println("No existe proveedors");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(proveedors);
	}
	
	@PostMapping
	
	public ResponseEntity<Proveedor> ingresarProveedor(@Valid @RequestBody Proveedor proveedor){
		
		Proveedor crearProveedor=servicioProveedor.createProveedor(proveedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearProveedor);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Proveedor> getProveedor(@PathVariable("id") Long id){
		Proveedor proveedor =servicioProveedor.getProveedor(id);
		if (proveedor==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedor);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Proveedor> updateProveedor(@PathVariable("id") Long id,@RequestBody Proveedor proveedor){
		proveedor.setId(id);
		Proveedor proveedorBD=servicioProveedor.updateProveedor(proveedor);
		
		if(proveedorBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedorBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<Proveedor> eliminar( @PathVariable(name="id") Long id) {
		try {
			servicioProveedor.deleteProveedor(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	}
	
}
