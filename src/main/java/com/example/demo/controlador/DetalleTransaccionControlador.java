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

import com.example.demo.entidades.DetalleTransaccion;
import com.example.demo.servicio.ServicioDetalleTransaccion;

@RestController
@RequestMapping(value="/detalles-transacciones")
public class DetalleTransaccionControlador {
	@Autowired
	private ServicioDetalleTransaccion servicioDetalleTransaccion;
	
	@GetMapping
	public ResponseEntity<List<DetalleTransaccion>> listarDetalleTransaccion(){
		List<DetalleTransaccion> detalleTransaccions=servicioDetalleTransaccion.listAllDetalleTransaccion();
		if(detalleTransaccions.isEmpty()) {
			System.out.println("No existe detalleTransaccions");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(detalleTransaccions);
	}
	
	@PostMapping
	
	public ResponseEntity<DetalleTransaccion> ingresarDetalleTransaccion(@Valid @RequestBody DetalleTransaccion detalleTransaccion){
		
		DetalleTransaccion crearDetalleTransaccion=servicioDetalleTransaccion.createDetalleTransaccion(detalleTransaccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearDetalleTransaccion);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalleTransaccion> getDetalleTransaccion(@PathVariable("id") Long id){
		DetalleTransaccion detalleTransaccion =servicioDetalleTransaccion.getDetalleTransaccion(id);
		if (detalleTransaccion==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleTransaccion);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DetalleTransaccion> updateDetalleTransaccion(@PathVariable("id") Long id,@RequestBody DetalleTransaccion detalleTransaccion){
		detalleTransaccion.setId(id);
		DetalleTransaccion detalleTransaccionBD=servicioDetalleTransaccion.updateDetalleTransaccion(detalleTransaccion);
		
		if(detalleTransaccionBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleTransaccionBD);
	}

}
