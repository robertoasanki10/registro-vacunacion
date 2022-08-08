package com.kg.web.vacunas.controller;

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

import com.kg.web.vacunas.dto.RegistroVacunasDto;
import com.kg.web.vacunas.model.RegistroVacunasEntity;
import com.kg.web.vacunas.model.TipoVacunasEntity;
import com.kg.web.vacunas.service.RegistroVacunasService;

@RestController
@RequestMapping("vacunas")
public class VacunacionController {

	@Autowired
	private RegistroVacunasService registroVacunasService;

	@PostMapping("/guardar")
	public void guardarTipoVacuna(@Valid @RequestBody TipoVacunasEntity tipoVacuna) {
		registroVacunasService.guardarActualizar(tipoVacuna);
	}

	@GetMapping("/listar")
	public List<TipoVacunasEntity> listar() {
		return registroVacunasService.buscarVacunas();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		registroVacunasService.eliminarVacunaPorId(id);
	}

	@PutMapping("/actualizar")
	public void actualizar(@Valid @RequestBody TipoVacunasEntity tipoVacuna) {
		registroVacunasService.guardarActualizar(tipoVacuna);
	}

	@PostMapping("/registrar-vacuna")
	public void crearRegistroVacunacion(@Valid @RequestBody RegistroVacunasDto registroVacunasDto) {
		registroVacunasService.crearRegistroVacunacion(registroVacunasDto);
	}
	
	@GetMapping("/listar-registro-vacunas")
	public List<RegistroVacunasEntity> listarRegistroVacunas() {
		return registroVacunasService.listarRegistroVacunas();
	}
	
	
}
