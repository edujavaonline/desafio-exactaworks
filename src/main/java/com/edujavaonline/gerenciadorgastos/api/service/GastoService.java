package com.edujavaonline.gerenciadorgastos.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edujavaonline.gerenciadorgastos.api.model.dto.GastoDTO;
import com.edujavaonline.gerenciadorgastos.api.model.dto.TagDTO;
import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;
import com.edujavaonline.gerenciadorgastos.api.model.entity.Tag;
import com.edujavaonline.gerenciadorgastos.api.repository.GastoRepository;
import com.edujavaonline.gerenciadorgastos.api.repository.filter.GastoFilter;
import com.edujavaonline.gerenciadorgastos.api.service.exception.ObjectNotFoundException;
import com.edujavaonline.gerenciadorgastos.api.util.Message;

@Service
public class GastoService {

	@Autowired
	private GastoRepository gastoRepository;
	
	public Page<Gasto> findAll(GastoFilter gastoFilter, Pageable pageable) {
		return gastoRepository.filtrar(gastoFilter, pageable);
	}
	
	@Transactional
	public Gasto save(Gasto gasto) {		
		return gastoRepository.save(gasto);
	}
	
	public Gasto update(Gasto gasto) {
		Gasto gastoRetornado = findById(gasto.getId());
		BeanUtils.copyProperties(gasto, gastoRetornado);
		return gastoRepository.save(gastoRetornado);
	}
	
	public Gasto findById(Long id) {
		Optional<Gasto> gastoRetornado = gastoRepository.findById(id);
		return gastoRetornado.orElseThrow(
				() -> new ObjectNotFoundException(Message.MSG_OBJECT_NOT_FOUND.replace("?", "Gasto")));
	}
	
	public void delete(Long id) {
		findById(id);
		gastoRepository.deleteById(id);			
	}
	
	
	public Gasto fromDTO(GastoDTO gastoDTO) {		
		Gasto gasto = new Gasto(null, gastoDTO.getNomePessoa(), gastoDTO.getDescricao(), gastoDTO.getDataHora(),gastoDTO.getValor());
		for(TagDTO dto : gastoDTO.getTags()) {
			Tag tag = new Tag(dto.getId(), dto.getDescricao());
			//tag.getGastos().add(gasto);
			gasto.getTags().add(tag);			
		}		
		return gasto;
	}	
	
}
