package com.example.demo.entidades;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "tbl_transaccion")
@Data
public class Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long cantidadProducto;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_detalle")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private DetalleTransaccion detalleTransaccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medicamento")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Medicamento medicamento;
}
