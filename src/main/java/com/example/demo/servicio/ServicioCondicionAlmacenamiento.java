package com.example.demo.servicio;

import java.util.List;

import com.example.demo.entidades.CondicionAlmacenamiento;

public interface ServicioCondicionAlmacenamiento {
	
	public List<CondicionAlmacenamiento> listAllCondicionAlmacenamiento();
	
	public CondicionAlmacenamiento getCondicionAlmacenamiento(Long id);
	
	public CondicionAlmacenamiento createCondicionAlmacenamiento(CondicionAlmacenamiento CondicionAlmacenamiento);
	
	public CondicionAlmacenamiento updateCondicionAlmacenamiento(CondicionAlmacenamiento CondicionAlmacenamiento);
	
	public void deleteCondicionAlmacenamiento(Long id);
}
