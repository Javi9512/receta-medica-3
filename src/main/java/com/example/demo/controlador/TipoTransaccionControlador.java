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

import com.example.demo.entidades.CaracteristicaMedicamento;
import com.example.demo.entidades.TipoTransaccion;

import com.example.demo.servicio.ServicioTipoTransaccion;

@RestController
@RequestMapping(value="/tipos-transacciones")
public class TipoTransaccionControlador {
	TipoTransaccion ultimo;
	@Autowired
	private ServicioTipoTransaccion servicioTipoTransaccion;
	
	@GetMapping
	public ResponseEntity<List<TipoTransaccion>> listarTipoTransaccion(){
		List<TipoTransaccion> tipoTransaccions=servicioTipoTransaccion.listAllTipoTransaccion();
		if(tipoTransaccions.isEmpty()) {
			System.out.println("No existe tipoTransaccions");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tipoTransaccions);
	}
	
	@PostMapping
	
	public ResponseEntity<TipoTransaccion> ingresarTipoTransaccion(@Valid @RequestBody TipoTransaccion tipoTransaccion){
		
		TipoTransaccion crearTipoTransaccion=servicioTipoTransaccion.createTipoTransaccion(tipoTransaccion);
		ultimo=crearTipoTransaccion;
		return ResponseEntity.status(HttpStatus.CREATED).body(crearTipoTransaccion);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoTransaccion> getTipoTransaccion(@PathVariable("id") Long id){
		TipoTransaccion tipoTransaccion =servicioTipoTransaccion.getTipoTransaccion(id);
		if (tipoTransaccion==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tipoTransaccion);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TipoTransaccion> updateTipoTransaccion(@PathVariable("id") Long id,@RequestBody TipoTransaccion tipoTransaccion){
		tipoTransaccion.setId(id);
		TipoTransaccion tipoTransaccionBD=servicioTipoTransaccion.updateTipoTransaccion(tipoTransaccion);
		
		if(tipoTransaccionBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tipoTransaccionBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<TipoTransaccion> eliminar( @PathVariable(name="id") Long id) {
		try {
			servicioTipoTransaccion.deleteTipoTransaccion(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/ultimo")
	public ResponseEntity<TipoTransaccion> obtenrUltimo(){
		if(ultimo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ultimo);
	}
	
}
