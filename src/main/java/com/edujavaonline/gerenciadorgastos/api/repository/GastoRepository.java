package com.edujavaonline.gerenciadorgastos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;
import com.edujavaonline.gerenciadorgastos.api.repository.gasto.GastoRepositoryQuery;

public interface GastoRepository extends JpaRepository<Gasto, Long>, GastoRepositoryQuery{

}
