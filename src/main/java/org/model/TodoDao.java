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
	 *  Contexto de Persistencia
	 */
	@PersistenceContext
	EntityManager em;	
	
	/*
	 * Inserir	
	 */
	@Transactional
	public void inserir (Todo todo) {
		String nomeSql = "INSERIR_TODO";
		Query query = em.createNamedQuery(nomeSql);
		
//		query.setParameter("id", todo.getId());
		query.setParameter("nome", todo.getNome());
		//query.setParameter("dataCriacao", todo.getDataCriacao());
		query.executeUpdate();
		
	}
	/*
	 *  listar	
	 */
	public List<Todo> listar(){
		String nomeConsulta = "CONSULTAR_TODO";
		List<Todo> listaRetorno;
		TypedQuery<Todo> query = em.createNamedQuery(nomeConsulta, Todo.class);
		
		try {
			listaRetorno = query.getResultList();
		}catch (NoResultException e) {
			listaRetorno = new ArrayList<>();
		}
		return listaRetorno;
		
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
}
