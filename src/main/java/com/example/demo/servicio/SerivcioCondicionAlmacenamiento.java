package com.example.demo.servicio;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.CondicionAlmacenamiento;
import com.example.demo.repositorio.CondicionAlmacenamientoRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerivcioCondicionAlmacenamiento implements ServicioCondicionAlmacenamiento{

	private final CondicionAlmacenamientoRepositorio condicionAlmacenamientoRepositorio;

	@Override
	public List<CondicionAlmacenamiento> listAllCondicionAlmacenamiento() {
		// TODO Auto-generated method stub
		return condicionAlmacenamientoRepositorio.findAll();
	}

	@Override
	public CondicionAlmacenamiento getCondicionAlmacenamiento(Long id) {
		// TODO Auto-generated method stub
		return condicionAlmacenamientoRepositorio.findById(id).orElse(null);
	}

	@Override
	public CondicionAlmacenamiento createCondicionAlmacenamiento(CondicionAlmacenamiento condicionAlmacenamiento) {
		// TODO Auto-generated method stub
		
		return condicionAlmacenamientoRepositorio.save(condicionAlmacenamiento);
	}

	@Override
	public CondicionAlmacenamiento updateCondicionAlmacenamiento(CondicionAlmacenamiento condicionAlmacenamiento) {
		// TODO Auto-generated method stub
		CondicionAlmacenamiento condicionAlmacenamientobd=getCondicionAlmacenamiento(condicionAlmacenamiento.getId());
		if(condicionAlmacenamientobd==null) {
			return null;
		}
				
		return condicionAlmacenamientoRepositorio.save(condicionAlmacenamiento);
		
		
	}

	@Override
	public CondicionAlmacenamiento deleteCondicionAlmacenamiento(Long id) {
		// TODO Auto-generated method stub
		CondicionAlmacenamiento condicionAlmacenamientobd=getCondicionAlmacenamiento(id);
		if(condicionAlmacenamientobd==null) {
			return null;
		}
		condicionAlmacenamientoRepositorio.delete(condicionAlmacenamientobd);
		return null ;
	}

}
