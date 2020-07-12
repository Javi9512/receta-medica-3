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

import com.example.demo.entidades.Medicamento;
import com.example.demo.servicio.ServicioMedicamento;

@RestController
@RequestMapping(value="/medicamentos")
public class MedicamentoControlador {
	

	@Autowired
	private ServicioMedicamento servicioMedicamento;
	
	@GetMapping
	public ResponseEntity<List<Medicamento>> listarMedicamento(){
		List<Medicamento> medicamentos=servicioMedicamento.listAllMedicamento();
		if(medicamentos.isEmpty()) {
			System.out.println("No existe medicamentos");
			return ResponseEntity.noContent().build();
		}
		for (Medicamento medicamento : medicamentos) {
			medicamento.setEnfermedades(null);
		}
		return ResponseEntity.ok(medicamentos);
	}
	
	@PostMapping
	
	public ResponseEntity<Medicamento> ingresarMedicamento(@Valid @RequestBody Medicamento medicamento){
		
		Medicamento crearMedicamento=servicioMedicamento.createMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(crearMedicamento);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Medicamento> getMedicamento(@PathVariable("id") Long id){
		Medicamento medicamento =servicioMedicamento.getMedicamento(id);
		if (medicamento==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicamento);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Medicamento> updateMedicamento(@PathVariable("id") Long id,@RequestBody Medicamento medicamento){
		medicamento.setId(id);
		Medicamento medicamentoBD=servicioMedicamento.updateMedicamento(medicamento);
		
		if(medicamentoBD==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicamentoBD);
	}
	
	
}
