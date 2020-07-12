package com.example.demo.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Medicamento;
import com.example.demo.repositorio.MedicamentoRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioMedicamentoImpl implements ServicioMedicamento {
	
	private final MedicamentoRepositorio medicamentoRepositorio;

	@Override
	public List<Medicamento> listAllMedicamento() {
		// TODO Auto-generated method stub
		return medicamentoRepositorio.findAll();
	}

	@Override
	public Medicamento getMedicamento(Long id) {
		// TODO Auto-generated method stub
		return medicamentoRepositorio.findById(id).orElse(null);
	}

	@Override
	public Medicamento createMedicamento(Medicamento medicamento) {
		// TODO Auto-generated method stub
		medicamento.setFechaCreacion(new Date());
		return medicamentoRepositorio.save(medicamento);
	}

	@Override
	public Medicamento updateMedicamento(Medicamento medicamento) {
		// TODO Auto-generated method stub
		Medicamento medicamentobd=getMedicamento(medicamento.getId());
		if(medicamentobd==null) {
			return null;
		}
				
		return medicamentoRepositorio.save(medicamento);
		
		
	}

	@Override
	public Medicamento deleteMedicamento(Long id) {
		// TODO Auto-generated method stub
		Medicamento medicamentobd=getMedicamento(id);
		if(medicamentobd==null) {
			return null;
		}
		medicamentoRepositorio.delete(medicamentobd);
		return null ;
	}
}
