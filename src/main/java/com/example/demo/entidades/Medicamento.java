package com.example.demo.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "tbl_medicamento")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo_medicamento")
	private Long codigo;
	
	@Column(name = "codigo_barra")
	private String codigoDeBarra;
	
	@Column(name = "nombre_comercial")
	private String nombreComercial;
	
	@Column(name = "inventario_minimo")
	private Long inventarioMinimo;
	
	@Column(name = "precio_compra")
	private Double precioCompra;
	
	@Column(name = "precio_venta")
	private Double precioVenta;
	
	@Column(name = "activo_medicamento")
	private Boolean activo;
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_caracteristica")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private CaracteristicaMedicamento caracteristicaMedicamento;
	
	@ManyToMany(mappedBy = "medicamentos", fetch = FetchType.LAZY)

    private List<Enfermedad> enfermedades ;
}
