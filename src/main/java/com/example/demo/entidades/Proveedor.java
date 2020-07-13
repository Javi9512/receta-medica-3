package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_proveedor")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String razonSocial;
	private String correo;
	private String direccion;
	private String telefono;
	private String representanteLegal;
	private String permisoOperacion;
	
}
