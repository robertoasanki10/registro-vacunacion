package com.kg.web.vacunas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistroVacunasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistroVacuna;

	@Column
	private Integer idEmpleado;

	@Column
	private Integer idVacuna;

	@Column
	private Date fechaVacunacion;

	@Column
	private Integer numeroDosis;

	public Integer getIdRegistroVacuna() {
		return idRegistroVacuna;
	}

	public void setIdRegistroVacuna(Integer idRegistroVacuna) {
		this.idRegistroVacuna = idRegistroVacuna;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Integer getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(Integer numeroDosis) {
		this.numeroDosis = numeroDosis;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}

}
