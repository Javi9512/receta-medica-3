package com.example.demo.entidades;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_enfermedad")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Enfermedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private String tipo;
	private boolean transmisible;
	private String mortalidad;
	
	
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	    @JoinTable(name = "enfermedad_medicamento",
	            joinColumns = {
	                    @JoinColumn(name = "enfermedad_id", referencedColumnName = "id",
	                            nullable = false, updatable = false)},
	            inverseJoinColumns = {
	                    @JoinColumn(name = "medicamento_id", referencedColumnName = "id",
	                            nullable = false, updatable = false)})
	
	    private List<Medicamento> medicamentos ;
}
