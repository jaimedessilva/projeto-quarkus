package org.service;

import java.util.List;
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
	 * validação
	 */
	private void validar(Todo todo) {
		// validar regra de negocio

		if (dao.nomeRepetido(todo.getNome())) {
			throw new NotFoundException();
		}
	}

	/*
	 * Listar
	 */
	public List<TodoDto> listar() {
		return dao.listar().stream().map(TodoParser.get()::dto).collect(Collectors.toList());
	}

	/*
	 * Get By ID
	 */
	public TodoDto buscar(Long id) {
		return TodoParser.get().dto(buscarPorId(id));
	}
	
	private Todo buscarPorId (Long id) {	
		Todo todo = dao.buscarPorId(id);
		if (todo == null) {
			throw new NotFoundException();
		}
		return todo;
	}

	/*
	 * Inserir
	 */
	@Transactional(rollbackOn = Exception.class)
	public void inserir(TodoDto todoDto) {
		// validadao
		Todo todo = TodoParser.get().entidade(todoDto);
		validar(todo);

		// Chamada Dao
		dao.inserir(todo);
	}
	/*
	 * Update
	 */
	@Transactional(rollbackOn = Exception.class)
	public void atualizar(TodoDto todoDto) {
		Todo todo = TodoParser.get().entidade(todoDto);
		buscarPorId(todoDto.getId());
		//Dao
		dao.atualizar(todo);
	}
	/*
	 * Excluir
	 */
	public void excluir(Long id) {
		if (dao.buscarPorId(id) == null) {
			throw new NotFoundException();
		}
		dao.excluir(id);
	}
}
