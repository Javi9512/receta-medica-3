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
import com.example.demo.servicio.ServicioCondicionAlmacenamiento;

@RestController
@RequestMapping(value="/condiciones-almacenamiento")
public class CondicionAlmacenamientoControlador {

	@Autowired
	private ServicioCondicionAlmacenamiento servicioCondicionAlmacenamiento;
	
	@GetMapping
	public ResponseEntity<List<CondicionAlmacenamiento>> listarCondicionAlmacenamiento(){
		List<CondicionAlmacenamiento> condicionAlmacenamientos=servicioCondicionAlmacenamiento.listAllCondicionAlmacenamiento();
		if(condicionAlmacenamientos.isEmpty()) {
			System.out.println("No existe condicionAlmacenamientos");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(condicionAlmacenamientos);
	}
	
	@PostMapping
	
	public ResponseEntity<CondicionAlmacenamiento> ingresarCondicionAlmacenamiento(@Valid @RequestBody CondicionAlmacenamiento condicionAlmacenamiento){
		
		CondicionAlmacenamiento crearCondicionAlmacenamiento=servicioCondicionAlmacenamiento.createCondicionAlmacenamiento(condicionAlmacenamiento);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearCondicionAlmacenamiento);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<CondicionAlmacenamiento> getCondicionAlmacenamiento(@PathVariable("id") Long id){
		CondicionAlmacenamiento condicionAlmacenamiento =servicioCondicionAlmacenamiento.getCondicionAlmacenamiento(id);
		if (condicionAlmacenamiento==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(condicionAlmacenamiento);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CondicionAlmacenamiento> updateCondicionAlmacenamiento(@PathVariable("id") Long id,@RequestBody CondicionAlmacenamiento condicionAlmacenamiento){
		condicionAlmacenamiento.setId(id);
		CondicionAlmacenamiento condicionAlmacenamientoBD=servicioCondicionAlmacenamiento.updateCondicionAlmacenamiento(condicionAlmacenamiento);
		
		if(condicionAlmacenamientoBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(condicionAlmacenamientoBD);
	}
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<CondicionAlmacenamiento> deleteUser( @PathVariable(name="id") Long id) {
		try {
			servicioCondicionAlmacenamiento.deleteCondicionAlmacenamiento(id);
		} catch (Exception e) {
			
		}
		return ResponseEntity.notFound().build();
	
	}
	

}
