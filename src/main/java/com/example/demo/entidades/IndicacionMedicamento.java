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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_indicacion_medicamento")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class IndicacionMedicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dosis;
	private Double diasTratamiento;
	private String frecuencia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receta_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Receta receta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medicamento")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Medicamento medicamento;
}
