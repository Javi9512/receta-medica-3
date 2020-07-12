package com.example.demo.controlador;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Null;

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

import com.example.demo.entidades.Enfermedad;
import com.example.demo.entidades.Medicamento;
import com.example.demo.servicio.ServicioEnfermedad;

@RestController
@RequestMapping(value="/enfermedades")
public class EnfermedadControlador {
	@Autowired
	private ServicioEnfermedad servicioEnfermedad;
	
	@GetMapping
	public ResponseEntity<List<Enfermedad>> listarEnfermedad(){
		List<Enfermedad> enfermedads=servicioEnfermedad.listAllEnfermedad();
		if(enfermedads.isEmpty()) {
			System.out.println("No existe enfermedads");
			return ResponseEntity.noContent().build();
		}
		
		for (Enfermedad enfermedad : enfermedads) {

			enfermedad.setMedicamentos(null);
		}
		return ResponseEntity.ok(enfermedads);
	}
	
	@PostMapping
	
	public ResponseEntity<Enfermedad> ingresarEnfermedad(@Valid @RequestBody Enfermedad enfermedad){
		
		Enfermedad crearEnfermedad=servicioEnfermedad.createEnfermedad(enfermedad);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearEnfermedad);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Enfermedad> getEnfermedad(@PathVariable("id") Long id){
		Enfermedad enfermedad =servicioEnfermedad.getEnfermedad(id);
		if (enfermedad==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(enfermedad);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Enfermedad> updateEnfermedad(@PathVariable("id") Long id,@RequestBody Enfermedad enfermedad){
		enfermedad.setId(id);
		Enfermedad enfermedadBD=servicioEnfermedad.updateEnfermedad(enfermedad);
		
		if(enfermedadBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(enfermedadBD);
	}
	
}
