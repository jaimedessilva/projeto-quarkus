package org.model.dto;

import org.model.Todo;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: TodoParser.java
 * Data: 30 de out de 2020 **/
public class TodoParser {
	
	public static TodoParser get() {
		return new TodoParser();
	}
	/*
	 *  Retorna Entidade
	 */
	public Todo entidade (TodoDto dto) {
		Todo entidade = new Todo();
		entidade.setId(dto.getId());
		entidade.setNome(dto.getNome());
		
		return entidade;
	}
	/*
	 * Retorna DTO
	 */
	public TodoDto dto(Todo entidade) {
		TodoDto dto = new TodoDto();
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		
		return dto;
	}

}
