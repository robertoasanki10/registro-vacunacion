package com.kg.web.vacunas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.web.vacunas.dto.DatosEmpleadoDto;
import com.kg.web.vacunas.model.EmpleadoEntity;
import com.kg.web.vacunas.model.RegistroVacunasEntity;
import com.kg.web.vacunas.repository.EmpleadoRepository;
import com.kg.web.vacunas.repository.RegistroVacunasRepository;
import com.kg.web.vacunas.repository.TipoVacunasRepository;

@Service
public class ConsultasGeneralesService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private RegistroVacunasRepository registroVacunasRepository;

	@Autowired
	private TipoVacunasRepository tipoVacunasRepository;

	public String devolverNombreVacuna(Integer idVacuna) {
		return tipoVacunasRepository.buscarPorIdVacuna(idVacuna).getNombreVacuna();
	}

	public List<DatosEmpleadoDto> completarInformacionEmpleado(List<DatosEmpleadoDto> listaDatos) {
		listaDatos.forEach((datos) -> {
			if ("Vacunado".equals(datos.getEstadoVacunacion())) {
				RegistroVacunasEntity registro = registroVacunasRepository
						.consultarVacunasDeEmpleado(datos.getIdEmpleado()).get(0);
				datos.setFechaVacunacion(registro.getFechaVacunacion());
				datos.setNumeroDosis(registro.getNumeroDosis());
				datos.setTipoVacuna(devolverNombreVacuna(registro.getIdVacuna()));
			}
		});
		return listaDatos;
	}

	public List<DatosEmpleadoDto> consultarPorEstadoVacuna(String estadoVacuna) {
		List<DatosEmpleadoDto> listaDatosEmpleados = new ArrayList<>();
		List<EmpleadoEntity> listaEmpleados = empleadoRepository.buscarPorEstadoVacuna(estadoVacuna);
		listaEmpleados.forEach((empleado) -> {
			DatosEmpleadoDto datos = new DatosEmpleadoDto();
			datos.setIdEmpleado(empleado.getIdEmpleado());
			datos.setApellido(empleado.getApellidos());
			datos.setNombre(empleado.getNombres());
			datos.setEstadoVacunacion(empleado.getEstadoVacunacion());
			listaDatosEmpleados.add(datos);
		});
		return completarInformacionEmpleado(listaDatosEmpleados);
	}

	private List<DatosEmpleadoDto> completarDatosBasicos(List<DatosEmpleadoDto> listaDatos) {
		listaDatos.forEach((datos) -> {
			EmpleadoEntity empleadoEntity = empleadoRepository.buscarPorIdEmpleado(datos.getIdEmpleado());
			datos.setNombre(empleadoEntity.getNombres());
			datos.setApellido(empleadoEntity.getApellidos());
			datos.setEstadoVacunacion(empleadoEntity.getEstadoVacunacion());
		});
		return listaDatos;
	}

	public List<DatosEmpleadoDto> consultarPorTipoVacuna(Integer idVacuna) {
		List<DatosEmpleadoDto> listaDatosEmpleadoDtos = new ArrayList<>();
		List<RegistroVacunasEntity> listaRegistroVacunasEntity = registroVacunasRepository
				.consultarPorTipoVacuna(idVacuna);
		listaRegistroVacunasEntity.forEach((registro) -> {
			DatosEmpleadoDto datos = new DatosEmpleadoDto();
			datos.setIdEmpleado(registro.getIdEmpleado());
			datos.setFechaVacunacion(registro.getFechaVacunacion());
			datos.setNumeroDosis(registro.getNumeroDosis());
			datos.setTipoVacuna(devolverNombreVacuna(registro.getIdVacuna()));
			listaDatosEmpleadoDtos.add(datos);
		});
		return completarDatosBasicos(listaDatosEmpleadoDtos);
	}
}
