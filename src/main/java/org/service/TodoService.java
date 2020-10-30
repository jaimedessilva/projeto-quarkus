package org.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.model.Todo;
import org.model.TodoDao;
import org.model.dto.TodoDto;
import org.model.dto.TodoParser;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: TodoService.java
 * Data: 29 de out de 2020 **/

@RequestScoped
public class TodoService {
	
	@Inject
	TodoDao dao;
	
	/*
	 *  validação
	 */
	private void validar(Todo todo) {
		//validar regra de negocio
		if (todo.getNome()== null) {
			throw new NotFoundException();
		}
	}
	/*
	 * Inserir
	 */
	@Transactional(rollbackOn = Exception.class)
	public void inserir (TodoDto todoDto) {
		//validadao
		Todo todo = TodoParser.get().entidade(todoDto);
		validar(todo);
		
		//Chamada Dao
		dao.inserir(todo);
	}
	/*
	 * Listar
	 */
	public List<TodoDto> listar(){
		return dao
				.listar()
				.stream()
				.map(TodoParser.get()::dto)
				.collect(Collectors.toList());
	}
	/*
	 * Excluir
	 */
	public void excluir(Long id) {
		dao.excluir(id);
	}
}
