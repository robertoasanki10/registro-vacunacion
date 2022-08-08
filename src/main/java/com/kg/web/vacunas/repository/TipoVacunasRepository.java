package com.kg.web.vacunas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kg.web.vacunas.model.TipoVacunasEntity;

@Repository
public interface TipoVacunasRepository extends JpaRepository<TipoVacunasEntity, Integer> {

	@Query(value = "select o from TipoVacunasEntity o where o.idVacuna = :idVacuna")
	TipoVacunasEntity buscarPorIdVacuna(@Param("idVacuna") Integer idVacuna);
}
