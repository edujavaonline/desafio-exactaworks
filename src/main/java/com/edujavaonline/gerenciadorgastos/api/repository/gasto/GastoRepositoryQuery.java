package com.edujavaonline.gerenciadorgastos.api.repository.gasto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;
import com.edujavaonline.gerenciadorgastos.api.repository.filter.GastoFilter;

public interface GastoRepositoryQuery {

	public Page<Gasto> filtrar(GastoFilter gastoFilter, Pageable pageable);
}
