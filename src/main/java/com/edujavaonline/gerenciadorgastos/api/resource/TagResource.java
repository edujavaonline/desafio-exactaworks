package com.edujavaonline.gerenciadorgastos.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Tag;
import com.edujavaonline.gerenciadorgastos.api.service.TagService;

@RestController
@RequestMapping(value = "/tags")
public class TagResource {
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TAG') and #oauth2.hasScope('read')")
	public ResponseEntity<List<Tag>> findAll() {
		List<Tag> tags = tagService.findAll();
		return ResponseEntity.ok().body(tags);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TAG') and #oauth2.hasScope('read')")
	public ResponseEntity<Tag> findById(@PathVariable Long id) {
		Tag tagRetornada = tagService.findById(id);
		return ResponseEntity.ok().body(tagRetornada);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_TAG') and #oauth2.hasScope('write')")
	public ResponseEntity<Tag> delete(@PathVariable Long id) {
		tagService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
