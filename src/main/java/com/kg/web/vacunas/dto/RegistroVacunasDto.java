package com.kg.web.vacunas.dto;

import java.util.Date;

public class RegistroVacunasDto {

	private Integer idRegistroVacuna;

	private Integer idEmpleado;

	private Integer idVacuna;

	private Date fechaVacunacion;

	private Integer numeroDosis;

	public Integer getIdRegistroVacuna() {
		return idRegistroVacuna;
	}

	public void setIdRegistroVacuna(Integer idRegistroVacuna) {
		this.idRegistroVacuna = idRegistroVacuna;
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

}
