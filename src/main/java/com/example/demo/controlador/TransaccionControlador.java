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

import com.example.demo.entidades.Transaccion;

import com.example.demo.servicio.ServicioTransaccion;

@RestController
@RequestMapping(value="/transacciones")
public class TransaccionControlador {
	@Autowired
	private ServicioTransaccion servicioTransaccion;
	
	@GetMapping
	public ResponseEntity<List<Transaccion>> listarTransaccion(){
		List<Transaccion> transaccions=servicioTransaccion.listAllTransaccion();
		if(transaccions.isEmpty()) {
			System.out.println("No existe transaccions");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(transaccions);
	}
	
	@PostMapping
	
	public ResponseEntity<Transaccion> ingresarTransaccion(@Valid @RequestBody Transaccion transaccion){
		
		Transaccion crearTransaccion=servicioTransaccion.createTransaccion(transaccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearTransaccion);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transaccion> getTransaccion(@PathVariable("id") Long id){
		Transaccion transaccion =servicioTransaccion.getTransaccion(id);
		if (transaccion==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(transaccion);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Transaccion> updateTransaccion(@PathVariable("id") Long id,@RequestBody Transaccion transaccion){
		transaccion.setId(id);
		Transaccion transaccionBD=servicioTransaccion.updateTransaccion(transaccion);
		
		if(transaccionBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(transaccionBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<Transaccion> eliminar( @PathVariable(name="id") Long id) {
		try {
			servicioTransaccion.deleteTransaccion(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	}
	
}
