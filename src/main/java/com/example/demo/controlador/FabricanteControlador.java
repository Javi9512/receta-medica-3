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

import com.example.demo.entidades.Fabricante;
import com.example.demo.servicio.ServicioFabricante;

@RestController
@RequestMapping(value="/fabricantes")
public class FabricanteControlador {

	@Autowired
	private ServicioFabricante servicioFabricante;
	
	@GetMapping
	public ResponseEntity<List<Fabricante>> listarFabricante(){
		List<Fabricante> fabricantes=servicioFabricante.listAllFabricante();
		if(fabricantes.isEmpty()) {
			System.out.println("No existe fabricantes");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(fabricantes);
	}
	
	@PostMapping
	
	public ResponseEntity<Fabricante> ingresarFabricante(@Valid @RequestBody Fabricante fabricante){
		
		Fabricante crearFabricante=servicioFabricante.createFabricante(fabricante);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearFabricante);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fabricante> getFabricante(@PathVariable("id") Long id){
		Fabricante fabricante =servicioFabricante.getFabricante(id);
		if (fabricante==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(fabricante);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Fabricante> updateFabricante(@PathVariable("id") Long id,@RequestBody Fabricante fabricante){
		fabricante.setId(id);
		Fabricante fabricanteBD=servicioFabricante.updateFabricante(fabricante);
		
		if(fabricanteBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(fabricanteBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<Fabricante> eliminar( @PathVariable(name="id") Long id) {
		try {
			servicioFabricante.deleteFabricante(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	}
}
