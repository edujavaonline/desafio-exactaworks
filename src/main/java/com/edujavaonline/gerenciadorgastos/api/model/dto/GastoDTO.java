package com.edujavaonline.gerenciadorgastos.api.model.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;


public class GastoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 100, message = "O tamanho deve estar entre 5 e 100 caracteres!")
    private String nomePessoa;

    @NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 150, message = "O tamanho deve estar entre 5 e 150 caracteres!")
    private String descricao;

    private LocalDateTime dataHora;

    @NotNull(message = "Preenchimento obrigatório!")
    private BigDecimal valor;
    
    private List<TagDTO> tags = new ArrayList<TagDTO>();  
    
    public GastoDTO() {}

	public GastoDTO(Gasto gasto) {
		super();
		this.id = gasto.getId();
		this.nomePessoa = gasto.getNomePessoa();
		this.descricao = gasto.getDescricao();
		this.dataHora = gasto.getDataHora();
		this.valor = gasto.getValor();	
		this.tags = gasto.getTags().stream().map(t -> new TagDTO(t)).collect(Collectors.toList());		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}    
}
