package com.kg.web.vacunas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TipoVacunasEntity {

	@Id
	private Integer idVacuna;

	@Column
	@NotBlank
	private String nombreVacuna;

	public Integer getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

}
