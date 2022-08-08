package com.kg.web.vacunas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpleadoActivoEntity {

	@Id
	private Integer idEmpleadoActivo;

	private String usuario;

	private String password;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "idEmpleado", insertable = false, updatable = false)
	 * private EmpleadoEntity empleadoEntity;
	 */

	public Integer getIdEmpleadoActivo() {
		return idEmpleadoActivo;
	}

	public void setIdEmpleadoActivo(Integer idEmpleadoActivo) {
		this.idEmpleadoActivo = idEmpleadoActivo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public EmpleadoEntity getEmpleado() { return empleadoEntity; }
	 * 
	 * public void setEmpleado(EmpleadoEntity empleadoEntity) { this.empleadoEntity
	 * = empleadoEntity; }
	 */

}
