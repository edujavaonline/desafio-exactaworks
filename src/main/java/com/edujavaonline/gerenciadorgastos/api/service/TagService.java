package com.edujavaonline.gerenciadorgastos.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Tag;
import com.edujavaonline.gerenciadorgastos.api.repository.TagRepository;
import com.edujavaonline.gerenciadorgastos.api.service.exception.DataIntegrityException;
import com.edujavaonline.gerenciadorgastos.api.service.exception.ObjectNotFoundException;
import com.edujavaonline.gerenciadorgastos.api.util.Message;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}
	
	public Tag findById(Long id) {
		Optional<Tag> tagRetornada = tagRepository.findById(id);
		return tagRetornada.orElseThrow(
				() -> new ObjectNotFoundException(Message.MSG_OBJECT_NOT_FOUND.replace("?", "Tag")));
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			tagRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(Message.MSG_DATA_INTEGRITY.replace("?", "Tag").replace("!", "Gasto"));
		}		
	}
}
