/**
 * 
 */
package org.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: Todo.java
 * Data: 29 de out de 2020 **/

@Entity
@Table(name="todo")
@NamedNativeQueries({
	@NamedNativeQuery(name="CONSULTAR_TODO", query="SELECT * FROM todo;", resultClass = Todo.class),
	@NamedNativeQuery(name="INSERIR_TODO", query = "INSERT INTO todo (nome, dataCriacao) values (:nome, now())"),
	@NamedNativeQuery(name="EXCLUIR_TODO", query = "DELETE from todo WHERE id = :id")
	})
public class Todo implements Serializable {
	
	/***/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name= "nome")
	private String nome;
	@Column (name="dataCriacao")
	private LocalDateTime dataCriacao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
