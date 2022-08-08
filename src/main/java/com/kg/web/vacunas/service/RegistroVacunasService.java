package com.kg.web.vacunas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.web.vacunas.dto.RegistroVacunasDto;
import com.kg.web.vacunas.model.RegistroVacunasEntity;
import com.kg.web.vacunas.model.TipoVacunasEntity;
import com.kg.web.vacunas.repository.RegistroVacunasRepository;
import com.kg.web.vacunas.repository.TipoVacunasRepository;

@Service
public class RegistroVacunasService {

	@Autowired
	private TipoVacunasRepository tipoVacunaRepository;

	@Autowired
	private RegistroVacunasRepository registroVacunasRepository;

	public TipoVacunasEntity guardarActualizar(TipoVacunasEntity tipoVacuna) {
		return tipoVacunaRepository.save(tipoVacuna);
	}

	public List<TipoVacunasEntity> buscarVacunas() {
		return tipoVacunaRepository.findAll();
	}

	public void eliminarVacunaPorId(Integer id) {
		tipoVacunaRepository.deleteById(id);
	}

	public List<RegistroVacunasEntity> listarRegistroVacunas() {
		return registroVacunasRepository.findAll();
	}

	public void crearRegistroVacunacion(RegistroVacunasDto registroVacunasDto) {
		RegistroVacunasEntity registroVacunasEntity = new RegistroVacunasEntity();
		registroVacunasEntity.setIdEmpleado(registroVacunasDto.getIdEmpleado());
		registroVacunasEntity.setIdVacuna(registroVacunasDto.getIdVacuna());
		registroVacunasEntity.setFechaVacunacion(registroVacunasDto.getFechaVacunacion());
		registroVacunasEntity.setNumeroDosis(registroVacunasDto.getNumeroDosis());
		registroVacunasRepository.save(registroVacunasEntity);
	}
}
