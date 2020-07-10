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


import com.example.demo.entidades.IndicacionMedicamento;
import com.example.demo.entidades.Receta;

import com.example.demo.servicio.ServicioIndicacionMedicamento;

@RestController
@RequestMapping(value = "/indicacionesmedicamentos")
public class IndicacionMedicamentoControlador {
	@Autowired
	private ServicioIndicacionMedicamento servicioIndicacionMedicamento;
	

	@GetMapping
	public ResponseEntity<List<IndicacionMedicamento>> listaIndicaciones(@RequestParam(name = "recetaId",required = false) Long idReceta){
		List<IndicacionMedicamento> lista= new ArrayList<>();
		
		if(null==idReceta) {
			lista=servicioIndicacionMedicamento.listAllIndicacionMedicamentos();
			if(lista.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			lista=servicioIndicacionMedicamento.findByReceta(Receta.builder().id(idReceta).build());
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<IndicacionMedicamento> getIndicacionMedicamento(@PathVariable("id") Long id){
		IndicacionMedicamento indicacion = servicioIndicacionMedicamento.getIndicacionMedicamento(id);
		if (indicacion==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(indicacion);
		
	}
	
	@PostMapping
	public ResponseEntity<IndicacionMedicamento> ingresarIndicacion(@Valid @RequestBody IndicacionMedicamento indicacionMedicamento){
		IndicacionMedicamento indicacion=servicioIndicacionMedicamento.createIndicacionGeneral(indicacionMedicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(indicacion);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<IndicacionMedicamento> updateProducto(@PathVariable("id") Long id,@RequestBody IndicacionMedicamento indicacionMedicamento){
		indicacionMedicamento.setId(id);
		IndicacionMedicamento indicacionBD=servicioIndicacionMedicamento.updateIndicacionMedicamento(indicacionMedicamento);
		
		if(indicacionBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(indicacionBD);
	}
	
 
}
