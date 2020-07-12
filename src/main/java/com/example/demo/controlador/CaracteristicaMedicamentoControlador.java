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
import com.example.demo.servicio.ServicioCaracteristicaMedicamento;

@RestController
@RequestMapping(value="/caracteristicas-medicamento")
public class CaracteristicaMedicamentoControlador {

	@Autowired
	private ServicioCaracteristicaMedicamento servicioCaracteristicaMedicamento;
	
	@GetMapping
	public ResponseEntity<List<CaracteristicaMedicamento>> listarCaracteristicaMedicamento(){
		List<CaracteristicaMedicamento> caracteristicaMedicamentos=servicioCaracteristicaMedicamento.listAllCaracteristicaMedicamento();
		if(caracteristicaMedicamentos.isEmpty()) {
			System.out.println("No existe caracteristicaMedicamentos");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(caracteristicaMedicamentos);
	}
	
	@PostMapping
	
	public ResponseEntity<CaracteristicaMedicamento> ingresarCaracteristicaMedicamento(@Valid @RequestBody CaracteristicaMedicamento caracteristicaMedicamento){
		
		CaracteristicaMedicamento crearCaracteristicaMedicamento=servicioCaracteristicaMedicamento.createCaracteristicaMedicamento(caracteristicaMedicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearCaracteristicaMedicamento);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<CaracteristicaMedicamento> getCaracteristicaMedicamento(@PathVariable("id") Long id){
		CaracteristicaMedicamento caracteristicaMedicamento =servicioCaracteristicaMedicamento.getCaracteristicaMedicamento(id);
		if (caracteristicaMedicamento==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(caracteristicaMedicamento);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CaracteristicaMedicamento> updateCaracteristicaMedicamento(@PathVariable("id") Long id,@RequestBody CaracteristicaMedicamento caracteristicaMedicamento){
		caracteristicaMedicamento.setId(id);
		CaracteristicaMedicamento caracteristicaMedicamentoBD=servicioCaracteristicaMedicamento.updateCaracteristicaMedicamento(caracteristicaMedicamento);
		
		if(caracteristicaMedicamentoBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(caracteristicaMedicamentoBD);
	}
	

}
