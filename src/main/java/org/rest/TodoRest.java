package org.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.model.dto.TodoDto;
import org.service.TodoService;

/**
 * Projeto: projeto-quarkus
 * @author: jaime Dev
 * File: TodoRest.java
 * Data: 29 de out de 2020 **/

@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRest {
	
	@Inject
	TodoService service;
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "API REST Projeto Quarkus";
    }
	/*
	 * GET
	 */
	@GET
	@Path("/listar")
	@Operation(summary ="Listar a Fazer", description ="Retorna uma lista de Todo.Class")
	@APIResponse(responseCode = "200", description = "lista de tarefas", content = {
			@Content(mediaType = "application/json",
			schema = @Schema(implementation = TodoDto.class, type = SchemaType.ARRAY)) })
	public Response listar() {
	return Response.status(Response.Status.OK)
			.entity(service.listar())
			.build();
	}
	/*
	 * POST
	 */
	@POST
	@Path("")
	@Operation(summary ="Incluir Tarefa", description ="Incluir uma tarefa")
	@APIResponse(responseCode = "201", description = "lista de tarefas", content = {
			@Content(mediaType = "application/json",
			schema = @Schema(implementation = TodoDto.class)) 
			})
	public Response incluir (TodoDto todo) {
		service.inserir(todo);
		return Response.status(Response.Status.CREATED).build();
	}
	/*
	 *  DELETE
	 */
	@DELETE
	@Path("/{id}")
	@Operation(summary ="Excluir Tarefa", description ="excluir uma tarefa")
	@APIResponse(responseCode = "200", description = "exclusão de tarefa", content = {
			@Content(mediaType = "application/json",
			schema = @Schema(implementation = TodoDto.class)) 
			})
	public Response excluir (@PathParam("id") Long id) {
		service.excluir(id);
		return Response.status(Response.Status.ACCEPTED).build();
	}
}
