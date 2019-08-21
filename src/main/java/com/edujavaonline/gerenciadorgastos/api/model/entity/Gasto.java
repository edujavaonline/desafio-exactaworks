package com.edujavaonline.gerenciadorgastos.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tb_gasto")
public class Gasto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name = "nome_pessoa")
	private String nomePessoa;	
	
	@Column(name = "descricao_gasto")
	private String descricao;
	
	@Column(name = "data_hora")		
	private LocalDateTime dataHora;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@ManyToMany()
	@JoinTable(name = "tb_gasto_tag",
		joinColumns = @JoinColumn(name = "id_gasto"),
		inverseJoinColumns = @JoinColumn(name = "id_tag")	
	)
	private List<Tag> tags = new ArrayList<Tag>();

	public Gasto() {}	

	public Gasto(Long id, String nomePessoa, String descricao, LocalDateTime dataHora, BigDecimal valor) {
		super();
		this.id = id;
		this.nomePessoa = nomePessoa;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.valor = valor;
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gasto other = (Gasto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
