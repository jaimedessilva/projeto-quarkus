package org.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**Project: projeto-quarkus
 * File: ProdutoDto.java
 * @author jaime-Dev
 * Em 22-10-2020 **/

@Entity (name="tb_produto")
public class ProdutoDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	Double valor;
	Date dt_Criacao;
	/*
	 * Construct
	 */
	public ProdutoDto() {super();}
	//Fields
	public ProdutoDto(String nome, Double valor) {
		/*Data */
		this.id = null;
		this.nome = nome;
		this.valor = valor;	
	}
	
	/* Getter */
	public Long getId() {
		return id;
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
	public Double getValor() {
		return valor;
	}

	/* Setter */
	public void setValor(Double valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Produto:"
				+"\n id:" + id
				+"\n nome:" + nome 
				+ "\n valor:" + valor 
				+ "\n Data criacao:" + dt_Criacao;
	}
}
