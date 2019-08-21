package com.edujavaonline.gerenciadorgastos.api.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edujavaonline.gerenciadorgastos.api.model.dto.GastoDTO;
import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;
import com.edujavaonline.gerenciadorgastos.api.repository.filter.GastoFilter;
import com.edujavaonline.gerenciadorgastos.api.service.GastoService;

@RestController
@RequestMapping(value = "/gastos")
public class GastoResource {
	
	@Autowired
	private GastoService gastoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_GASTO') and #oauth2.hasScope('read')")
	public ResponseEntity<Page<GastoDTO>> findAll(GastoFilter gastoFilter, Pageable pageable) {
		Page<Gasto> gastos = gastoService.findAll(gastoFilter, pageable);
		Page<GastoDTO> gastosDTO = gastos.map(g -> new GastoDTO(g));
		return ResponseEntity.ok().body(gastosDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_GASTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Void> save(@Valid @RequestBody GastoDTO gastoDTO) {	
		Gasto gasto = gastoService.fromDTO(gastoDTO);
		gasto = gastoService.save(gasto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(gasto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_GASTO') and #oauth2.hasScope('read')")
	public ResponseEntity<GastoDTO> findById(@PathVariable Long id) {
		Gasto gastoRetornado = gastoService.findById(id);
		GastoDTO gastoDTO = new GastoDTO(gastoRetornado);		
		return ResponseEntity.ok().body(gastoDTO);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_GASTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Void> update(@Valid @RequestBody GastoDTO gastoDTO, @PathVariable Long id) {	
		Gasto gasto = gastoService.fromDTO(gastoDTO);
		gasto.setId(id);
		gasto = gastoService.update(gasto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(gasto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_GASTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Gasto> delete(@PathVariable Long id) {
		gastoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
