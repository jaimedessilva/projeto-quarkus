package org.model.dto;

import java.time.LocalDateTime;
import javax.json.bind.annotation.JsonbDateFormat;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: TodoDto.java
 * Data: 30 de out de 2020 **/

public class TodoDto {
	
	private Long id;
	
	private String nome;
	
	@JsonbDateFormat("dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacao;

	/* Getter */
	public Long getId() {
		return id;
	}

	/* Setter */
	public void setId(Long id) {
		this.id = id;
	}

	/* Getter */
	public String getNome() {
		return nome;
	}

	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* Getter */
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	/* Setter */
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
	
}
