package com.edujavaonline.gerenciadorgastos.api.repository.filter;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class GastoFilter {
	
	private String nomePessoa;
	
	private String descricao;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dataHoraDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dataHoraAte;

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

	public LocalDateTime getDataHoraDe() {
		return dataHoraDe;
	}

	public void setDataHoraDe(LocalDateTime dataHoraDe) {
		this.dataHoraDe = dataHoraDe;
	}

	public LocalDateTime getDataHoraAte() {
		return dataHoraAte;
	}

	public void setDataHoraAte(LocalDateTime dataHoraAte) {
		this.dataHoraAte = dataHoraAte;
	}

}
