package com.edujavaonline.gerenciadorgastos.api.model.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;
import com.edujavaonline.gerenciadorgastos.api.model.entity.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TagDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private String descricao;
    
    @JsonIgnore
    private List<Gasto> gastos = new ArrayList<Gasto>();
    
    public TagDTO() {}   
    

	public TagDTO(Tag tag) {
		super();
		this.setId(tag.getId());
		this.descricao = tag.getDescricao();		
	}

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Gasto> getGastos() {
		return gastos;
	}


	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
   
}
