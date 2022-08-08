package com.kg.web.vacunas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kg.web.vacunas.model.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

	@Query(value = "select estadoVacunacion from EmpleadoEntity o where o.idEmpleado = :idEmpleado")
	String verificarVacunado(@Param("idEmpleado") Integer idEmpleado);

	@Query(value = "select o from EmpleadoEntity o where o.idEmpleado = :idEmpleado")
	EmpleadoEntity buscarPorIdEmpleado(@Param("idEmpleado") Integer idEmpleado);

	@Query(value = "select o from EmpleadoEntity o where o.estadoVacunacion = :estadoVacunacion")
	List<EmpleadoEntity> buscarPorEstadoVacuna(@Param("estadoVacunacion") String estadoVacunacion);
}
