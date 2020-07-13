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

import com.example.demo.entidades.CondicionAlmacenamiento;
import com.example.demo.entidades.Receta;
import com.example.demo.servicio.ServicioReceta;

@RestController
@RequestMapping(value="/recetas")
public class RecetaControlador {
	Receta ultimo;
	@Autowired
	private ServicioReceta servicioReceta;
	
	@GetMapping
	public ResponseEntity<List<Receta>> listarReceta(){
		List<Receta> recetas=servicioReceta.listAllReceta();
		if(recetas.isEmpty()) {
			System.out.println("No existe recetas");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(recetas);
	}
	
	@PostMapping
	
	public ResponseEntity<Receta> ingresarReceta(@Valid @RequestBody Receta receta){
		
		Receta crearReceta=servicioReceta.createReceta(receta);
		ultimo =crearReceta;
		return ResponseEntity.status(HttpStatus.CREATED).body(crearReceta);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Receta> getReceta(@PathVariable("id") Long id){
		Receta receta =servicioReceta.getReceta(id);
		if (receta==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(receta);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Receta> updateReceta(@PathVariable("id") Long id,@RequestBody Receta receta){
		receta.setId(id);
		Receta recetaBD=servicioReceta.updateReceta(receta);
		
		if(recetaBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(recetaBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<Receta> deleteUser( @PathVariable(name="id") Long id) {
		try {
			servicioReceta.deleteReceta(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	}
	

}
