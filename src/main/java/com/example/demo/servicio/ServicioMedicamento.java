package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.Medicamento;



public interface ServicioMedicamento {
	
	public List<Medicamento> listAllMedicamento();
	
	public Medicamento getMedicamento(Long id);
	
	public Medicamento createMedicamento(Medicamento Medicamento);
	
	public Medicamento updateMedicamento(Medicamento Medicamento);
	
	public Medicamento deleteMedicamento(Long id);
	
}
