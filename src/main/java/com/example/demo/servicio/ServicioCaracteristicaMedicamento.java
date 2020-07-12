package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.CaracteristicaMedicamento;

public interface ServicioCaracteristicaMedicamento {
	
	public List<CaracteristicaMedicamento> listAllCaracteristicaMedicamento();
	
	public CaracteristicaMedicamento getCaracteristicaMedicamento(Long id);
	
	public CaracteristicaMedicamento createCaracteristicaMedicamento(CaracteristicaMedicamento caracteristicaMedicamento);
	
	public CaracteristicaMedicamento updateCaracteristicaMedicamento(CaracteristicaMedicamento caracteristicaMedicamento);
	
	public CaracteristicaMedicamento deleteCaracteristicaMedicamento(Long id);
}
