package com.kg.web.vacunas.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.web.vacunas.dto.EmpleadoRequestDto;
import com.kg.web.vacunas.model.EmpleadoEntity;
import com.kg.web.vacunas.repository.EmpleadoRepository;

@Service
public class RegistroEmpleadosService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public EmpleadoEntity guardarActualizar(EmpleadoEntity empleadoEntity) {
		return empleadoRepository.save(empleadoEntity);
	}

	public List<EmpleadoEntity> buscarEmpleados() {
		return empleadoRepository.findAll();
	}

	public void eliminarEmpleadoPorId(Integer id) {
		empleadoRepository.deleteById(id);
	}

	public void darAltaEmpleado(EmpleadoEntity empleadoEntity) {
		empleadoEntity.setUsuario(crearUsuario(empleadoEntity));
		empleadoEntity.setPassword(crearPassword());
		empleadoRepository.save(empleadoEntity);
	}

	private String crearUsuario(EmpleadoEntity empleadoEntity) {
		return empleadoEntity.getNombres().substring(0, 1).concat(empleadoEntity.getApellidos()).toLowerCase()
				.replaceAll("\\s+", "");
	}

	private String crearPassword() {
		return RandomStringUtils.randomAlphanumeric(6);
	}

	public boolean validarVacunacionPorIdEmpleado(Integer idEmpleado) {
		String vacunado = empleadoRepository.verificarVacunado(idEmpleado);
		return ("Vacunado".equals(vacunado)) ? true : false;
	}

	public void actualizarInformacionAdicional(EmpleadoRequestDto empleadoRequestDto) {
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
		empleadoEntity = empleadoRepository.buscarPorIdEmpleado(empleadoRequestDto.getIdEmpleado());
		if (empleadoEntity != null) {
			empleadoEntity.setDireccion(empleadoRequestDto.getDireccion());
			empleadoEntity.setFechaNacimiento(empleadoRequestDto.getFechaNacimiento());
			empleadoEntity.setTelefono(empleadoRequestDto.getTelefono());
			empleadoEntity.setEstadoVacunacion(empleadoRequestDto.getEstadoVacunacion());
			empleadoRepository.save(empleadoEntity);
		}
	}

}
