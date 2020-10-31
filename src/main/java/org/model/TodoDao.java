/**
 * 
 */
package org.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.eclipse.microprofile.opentracing.Traced;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: TodoDao.java
 * Data: 29 de out de 2020 **/

@RequestScoped
@Traced
public class TodoDao {

	/*
	 * Contexto de Persistencia
	 */
	@PersistenceContext
	EntityManager em;

	/*
	 * listar
	 */
	public List<Todo> listar() {
		String nomeConsulta = "CONSULTAR_TODO";
		List<Todo> listaRetorno;
		TypedQuery<Todo> query = em.createNamedQuery(nomeConsulta, Todo.class);

		try {
			listaRetorno = query.getResultList();
		} catch (NoResultException e) {
			listaRetorno = new ArrayList<>();
		}
		return listaRetorno;

	}
	/*
	 * Buscar por ID
	 */
	public Todo buscarPorId(Long id) {
		// SQL
		String nomeSql = "CONSULTAR_TODO_ID";
		Todo todo = null;
		TypedQuery<Todo> query = em.createNamedQuery(nomeSql, Todo.class);

		query.setParameter("id", id);

		try {
			todo = query.getSingleResult();
		} catch (NoResultException e) {
			todo = null;
		}
		return todo;
	}

	/*
	 * Inserir
	 */
	@Transactional
	public void inserir(Todo todo) {
		String nomeSql = "INSERIR_TODO";
		Query query = em.createNamedQuery(nomeSql);

//		query.setParameter("id", todo.getId());
		query.setParameter("nome", todo.getNome());
		// query.setParameter("dataCriacao", todo.getDataCriacao());
		query.executeUpdate();

	}
	/*
	 *  Atualizar
	 */
	@Transactional
	public void atualizar(Todo todo) {
		String nomeSql = "ATUALIZAR_TODO";
		Query query = em.createNamedQuery(nomeSql);
		query.setParameter("id", todo.getId());
		query.setParameter("nome", todo.getNome());
		//query.setParameter("datacriacao", todo.getDataCriacao());
		query.executeUpdate();
	}
	
	/*
	 * Excluir
	 */
	@Transactional
	public void excluir(Long id) {
		String nomeConsulta = "EXCLUIR_TODO";
		Query query = em.createNamedQuery(nomeConsulta);
		query.setParameter("id", id);

		query.executeUpdate();
	}

	/*
	 * Validar nome Repetido
	 */
	public Boolean nomeRepetido(String nome) {
		String nomeSql = "CONSULTAR_NOME_REPETIDO_TODO";
		Boolean nomeRepetido = Boolean.FALSE;

		TypedQuery<Todo> query = em.createNamedQuery(nomeSql, Todo.class);
		query.setParameter("nome", "%" + nome + "%");

		nomeRepetido = query.getResultList().size() > 0;

		return nomeRepetido;
	}
}







