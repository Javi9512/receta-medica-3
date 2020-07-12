package com.example.demo.servicio;

import java.util.List;


import com.example.demo.entidades.TipoTransaccion;

public interface ServicioTipoTransaccion {

	public List<TipoTransaccion> listAllTipoTransaccion();
	
	public TipoTransaccion getTipoTransaccion(Long id);
	
	public TipoTransaccion createTipoTransaccion(TipoTransaccion tipoTransaccion);
	
	public TipoTransaccion updateTipoTransaccion(TipoTransaccion tipoTransaccion);
	
	public TipoTransaccion deleteTipoTransaccion(Long id);
}
