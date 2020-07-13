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

import com.example.demo.entidades.FormaFarmaceutica;

import com.example.demo.servicio.ServicioFormaFarmaceutica;

@RestController
@RequestMapping(value="/formas-farmaceuticas")
public class FormaFarmaceuticaControlador {

	@Autowired
	private ServicioFormaFarmaceutica servicioFormaFarmaceutica;
	
	@GetMapping
	public ResponseEntity<List<FormaFarmaceutica>> listarFormaFarmaceutica(){
		List<FormaFarmaceutica> formaFarmaceuticas=servicioFormaFarmaceutica.listAllFormaFarmaceutica();
		if(formaFarmaceuticas.isEmpty()) {
			System.out.println("No existe formaFarmaceuticas");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(formaFarmaceuticas);
	}
	
	@PostMapping
	
	public ResponseEntity<FormaFarmaceutica> ingresarFormaFarmaceutica(@Valid @RequestBody FormaFarmaceutica formaFarmaceutica){
		
		FormaFarmaceutica crearFormaFarmaceutica=servicioFormaFarmaceutica.createFormaFarmaceutica(formaFarmaceutica);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearFormaFarmaceutica);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<FormaFarmaceutica> getFormaFarmaceutica(@PathVariable("id") Long id){
		FormaFarmaceutica formaFarmaceutica =servicioFormaFarmaceutica.getFormaFarmaceutica(id);
		if (formaFarmaceutica==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(formaFarmaceutica);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FormaFarmaceutica> updateFormaFarmaceutica(@PathVariable("id") Long id,@RequestBody FormaFarmaceutica formaFarmaceutica){
		formaFarmaceutica.setId(id);
		FormaFarmaceutica formaFarmaceuticaBD=servicioFormaFarmaceutica.updateFormaFarmaceutica(formaFarmaceutica);
		
		if(formaFarmaceuticaBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(formaFarmaceuticaBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<FormaFarmaceutica> eliminar( @PathVariable(name="id") Long id) {
		try {
			servicioFormaFarmaceutica.deleteFormaFarmaceutica(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	}
}
