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

import com.example.demo.entidades.ViaAdministracion;
import com.example.demo.servicio.ServicioViaAdministracion;

@RestController
@RequestMapping(value="/vias-administracion")
public class ViaAdministracionControlador {
	
	@Autowired
	private ServicioViaAdministracion servicioViaAdministracion;
	
	@GetMapping
	public ResponseEntity<List<ViaAdministracion>> listarViaAdministracion(){
		List<ViaAdministracion> viaAdministracions=servicioViaAdministracion.listAllViaAdministracion();
		if(viaAdministracions.isEmpty()) {
			System.out.println("No existe viaAdministracions");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(viaAdministracions);
	}
	
	@PostMapping
	
	public ResponseEntity<ViaAdministracion> ingresarViaAdministracion(@Valid @RequestBody ViaAdministracion viaAdministracion){
		
		ViaAdministracion crearViaAdministracion=servicioViaAdministracion.createViaAdministracion(viaAdministracion);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearViaAdministracion);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ViaAdministracion> getViaAdministracion(@PathVariable("id") Long id){
		ViaAdministracion viaAdministracion =servicioViaAdministracion.getViaAdministracion(id);
		if (viaAdministracion==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(viaAdministracion);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ViaAdministracion> updateViaAdministracion(@PathVariable("id") Long id,@RequestBody ViaAdministracion viaAdministracion){
		viaAdministracion.setId(id);
		ViaAdministracion viaAdministracionBD=servicioViaAdministracion.updateViaAdministracion(viaAdministracion);
		
		if(viaAdministracionBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(viaAdministracionBD);
	}
	
}
