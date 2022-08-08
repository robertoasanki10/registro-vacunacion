package com.kg.web.vacunas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kg.web.vacunas.model.RegistroVacunasEntity;

@Repository
public interface RegistroVacunasRepository extends JpaRepository<RegistroVacunasEntity, Integer> {

	@Query(value = "select o from RegistroVacunasEntity o where o.idEmpleado = :idEmpleado")
	List<RegistroVacunasEntity> consultarVacunasDeEmpleado(@Param("idEmpleado") Integer idEmpleado);

	@Query(value = "select o from RegistroVacunasEntity o where o.idVacuna = :idVacuna")
	List<RegistroVacunasEntity> consultarPorTipoVacuna(@Param("idVacuna") Integer idVacuna);
}
