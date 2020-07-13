package com.example.demo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "tbl_detalle_transaccion")
@Data
public class DetalleTransaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double totalVenta;
	private String persona;
	
	@Column(name = "fecha_emision")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_transaccion")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private TipoTransaccion tipoTransaccion;

}
