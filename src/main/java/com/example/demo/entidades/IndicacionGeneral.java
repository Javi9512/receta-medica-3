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
@Table(name="tbl_indicacionGenral")
@Data
public class IndicacionGeneral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String concepto;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receta_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Receta receta;

}
