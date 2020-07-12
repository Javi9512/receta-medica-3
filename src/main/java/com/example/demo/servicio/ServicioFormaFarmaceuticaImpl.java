package com.example.demo.servicio;


import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.FormaFarmaceutica;
import com.example.demo.repositorio.FormaFarmaceuticaRepositorio;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioFormaFarmaceuticaImpl implements ServicioFormaFarmaceutica {
	
	private final FormaFarmaceuticaRepositorio formaFarmaceuticaRepositorio;

	@Override
	public List<FormaFarmaceutica> listAllFormaFarmaceutica() {
		// TODO Auto-generated method stub
		return formaFarmaceuticaRepositorio.findAll();
	}

	@Override
	public FormaFarmaceutica getFormaFarmaceutica(Long id) {
		// TODO Auto-generated method stub
		return formaFarmaceuticaRepositorio.findById(id).orElse(null);
	}

	@Override
	public FormaFarmaceutica createFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
		// TODO Auto-generated method stub
		return formaFarmaceuticaRepositorio.save(formaFarmaceutica);
	}

	@Override
	public FormaFarmaceutica updateFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
		// TODO Auto-generated method stub
		FormaFarmaceutica formaFarmaceuticabd=getFormaFarmaceutica(formaFarmaceutica.getId());
		if(formaFarmaceuticabd==null) {
			return null;
		}
				
		return formaFarmaceuticaRepositorio.save(formaFarmaceutica);
		
		
	}

	@Override
	public FormaFarmaceutica deleteFormaFarmaceutica(Long id) {
		// TODO Auto-generated method stub
		FormaFarmaceutica formaFarmaceuticabd=getFormaFarmaceutica(id);
		if(formaFarmaceuticabd==null) {
			return null;
		}
		formaFarmaceuticaRepositorio.delete(formaFarmaceuticabd);
		return null ;
	}
}
