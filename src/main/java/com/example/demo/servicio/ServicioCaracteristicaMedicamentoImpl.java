package com.example.demo.servicio;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.CaracteristicaMedicamento;
import com.example.demo.repositorio.CaracteristicaMedicamentoRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioCaracteristicaMedicamentoImpl implements ServicioCaracteristicaMedicamento {

	private final CaracteristicaMedicamentoRepositorio caracteristicaMedicamentoRepositorio;

	@Override
	public List<CaracteristicaMedicamento> listAllCaracteristicaMedicamento() {
		// TODO Auto-generated method stub
		return caracteristicaMedicamentoRepositorio.findAll();
	}

	@Override
	public CaracteristicaMedicamento getCaracteristicaMedicamento(Long id) {
		// TODO Auto-generated method stub
		return caracteristicaMedicamentoRepositorio.findById(id).orElse(null);
	}

	@Override
	public CaracteristicaMedicamento createCaracteristicaMedicamento(CaracteristicaMedicamento caracteristicaMedicamento) {
		// TODO Auto-generated method stub
	
		return caracteristicaMedicamentoRepositorio.save(caracteristicaMedicamento);
	}

	@Override
	public CaracteristicaMedicamento updateCaracteristicaMedicamento(CaracteristicaMedicamento caracteristicaMedicamento) {
		// TODO Auto-generated method stub
		CaracteristicaMedicamento caracteristicaMedicamentobd=getCaracteristicaMedicamento(caracteristicaMedicamento.getId());
		if(caracteristicaMedicamentobd==null) {
			return null;
		}
				
		return caracteristicaMedicamentoRepositorio.save(caracteristicaMedicamento);
		
		
	}

	@Override
	public void deleteCaracteristicaMedicamento(Long id) {
		// TODO Auto-generated method stub
		CaracteristicaMedicamento caracteristicaMedicamentobd=getCaracteristicaMedicamento(id);
		if(caracteristicaMedicamentobd==null) {
			return;
		}
		caracteristicaMedicamentoRepositorio.delete(caracteristicaMedicamentobd);
		
	}
}
