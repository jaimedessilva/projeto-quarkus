package org.model.dto;

import java.time.LocalDateTime;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: TodoDto.java
 * Data: 30 de out de 2020 **/

public class TodoDto {
	
	private Long id;
	@NotNull(message = "Campo não pode ser Nulo")
	@NotBlank (message = "Este campo deve conter valores ")
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
