package com.kg.web.vacunas.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kg.web.vacunas.dto.DatosEmpleadoDto;
import com.kg.web.vacunas.dto.EmpleadoRequestDto;
import com.kg.web.vacunas.model.EmpleadoEntity;
import com.kg.web.vacunas.service.ConsultasGeneralesService;
import com.kg.web.vacunas.service.RegistroEmpleadosService;

@RestController
@RequestMapping("empleados")
public class AdministracionEmpleadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RegistroEmpleadosService registroEmpleadoService;

	@Autowired
	private ConsultasGeneralesService consultasGeneralesService;

	@PostMapping("/guardar")
	public void darAltaEmpleado(@Valid @RequestBody EmpleadoEntity empleadoEntity) {
		registroEmpleadoService.darAltaEmpleado(empleadoEntity);
	}

	@GetMapping("/listar")
	public List<EmpleadoEntity> listar() {
		return registroEmpleadoService.buscarEmpleados();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		registroEmpleadoService.eliminarEmpleadoPorId(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody EmpleadoEntity empleadoEntity) {
		registroEmpleadoService.guardarActualizar(empleadoEntity);
	}

	@GetMapping("/validar-vacunacion/{idEmpleado}")
	public boolean validarVacunacionPorIdEmpleado(@PathVariable("idEmpleado") Integer idEmpleado) {
		return registroEmpleadoService.validarVacunacionPorIdEmpleado(idEmpleado);
	}

	@PostMapping("/actualizar-adicional")
	public void actualizarInformacionAdicional(@Valid @RequestBody EmpleadoRequestDto empleadoRequestDto) {
		registroEmpleadoService.actualizarInformacionAdicional(empleadoRequestDto);
	}

	@GetMapping("/listar-por-estado-vacuna/{estadoVacuna}")
	public List<DatosEmpleadoDto> consultarPorEstadoVacunacion(
			@PathVariable("estadoVacuna") @RequestBody String estadoVacuna) {
		return consultasGeneralesService.consultarPorEstadoVacuna(estadoVacuna);
	}

	@GetMapping("/listar-por-tipo-vacuna/{idVacuna}")
	public List<DatosEmpleadoDto> consultarPorTipoVacuna(@PathVariable @RequestBody Integer idVacuna) {
		return consultasGeneralesService.consultarPorTipoVacuna(idVacuna);
	}
}
