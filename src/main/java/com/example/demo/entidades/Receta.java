package com.example.demo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tbl_receta")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Receta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_emision")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name = "id_paciente")
	private String idPaciente;
	
	@Column(name = "id_medico")
	private String idMedico;

}
