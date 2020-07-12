package com.example.demo.entidades;

import java.util.Date;

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
@Table(name = "tbl_caracteristica")
@Data
public class CaracteristicaMedicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "leyenda_medicamento")
	private String leyenda;
	
	@JoinColumn(name = "advertencia_medicamento")
	private String advertencia;
	
	@JoinColumn(name = "nombre_generico")
	private String nombreGenerico;
	
	@JoinColumn(name = "concentracion_medicamento")
	private String concentracion;
	
	@JoinColumn(name = "composicion_medicamento")
	private String composicion;
	
	@JoinColumn(name = "registro_sanitario")
	private String numeroRegistroSanitario;
	
	
	@JoinColumn(name = "fecha_expiracion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaExpiracion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_forma_farmaceutica")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private FormaFarmaceutica formaFarmaceutica;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_via_administracion")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private ViaAdministracion viaAdministracion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_condicion_almacenamiento")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private CondicionAlmacenamiento condicionAlmacenamiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fabricante")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Fabricante fabricante ;
}
