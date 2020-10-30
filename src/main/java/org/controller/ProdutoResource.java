package org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.model.ProdutoDto;

/**Project: projeto-quarkus
 * File: ProdutoResource.java
 * @author jaime-Dev
 * Em 22-10-2020 **/

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	
	List<ProdutoDto> produtos = new ArrayList<ProdutoDto>();
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "API REST Projeto Quarkus";
    }
	
	@Path("/produtos")
	@GET
	public List<ProdutoDto> init() {
		//Lista
		produtos.add(new ProdutoDto("Computador",2599.95));
		produtos.add(new ProdutoDto("TV 50 4K",1999.90));
		produtos.add(new ProdutoDto("SmartFone Xiaomi",1599.90));
		produtos.add(new ProdutoDto("smartwatch",388.90));
		
		return produtos;	
	}
	
}
