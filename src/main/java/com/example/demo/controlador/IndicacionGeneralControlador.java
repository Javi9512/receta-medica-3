package com.example.demo.controlador;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.IndicacionGeneral;
import com.example.demo.entidades.Receta;
import com.example.demo.servicio.ServicioIndicacionGeneral;

@RestController
@RequestMapping(value = "/indicacionesgenerales")
public class IndicacionGeneralControlador {
	
	@Autowired
	private ServicioIndicacionGeneral servicioIndicacionGeneral;
	
	@GetMapping
	public ResponseEntity<List<IndicacionGeneral>> listaIndicaciones(@RequestParam(name = "recetaId",required = false) Long idReceta){
		List<IndicacionGeneral> lista= new ArrayList<>();
		
		if(null==idReceta) {
			lista=servicioIndicacionGeneral.listAllIndicacionGenerals();
			if(lista.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			lista=servicioIndicacionGeneral.findByReceta(Receta.builder().id(idReceta).build());
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<IndicacionGeneral> getIndicacionGeneral(@PathVariable("id") Long id){
		IndicacionGeneral indicacion = servicioIndicacionGeneral.getIndicacionGeneral(id);
		if (indicacion==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(indicacion);
		
	}
	
	@PostMapping
	public ResponseEntity<IndicacionGeneral> ingresarIndicacion(@Valid @RequestBody IndicacionGeneral indicacionGeneral){
		IndicacionGeneral indicacion=servicioIndicacionGeneral.createIndicacionGeneral(indicacionGeneral);
		return ResponseEntity.status(HttpStatus.CREATED).body(indicacion);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<IndicacionGeneral> updateProducto(@PathVariable("id") Long id,@RequestBody IndicacionGeneral indicacionGeneral){
		indicacionGeneral.setId(id);
		IndicacionGeneral indicacionBD=servicioIndicacionGeneral.updateIndicacionGeneral(indicacionGeneral);
		
		if(indicacionBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(indicacionBD);
	}
	
}
