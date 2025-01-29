package com.example.resources;

import java.util.List;
import java.util.UUID;

import com.example.dao.TodoDao;
import com.example.model.Todo;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Named
@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    private final TodoDao todoDao;

    @Inject
    public TodoResource(@Named("inMemory") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @GET
    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    @GET
    @Path("/{id}")
    public Response getTodo(@PathParam("id") UUID id) {
        return todoDao.getTodo(id)
                .map(todo -> Response.ok(todo).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response createTodo(Todo todo) {
        Todo created = todoDao.createTodo(todo);
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTodo(@PathParam("id") UUID id, Todo todo) {
        return todoDao.updateTodo(id, todo)
                .map(updated -> Response.ok(updated).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTodo(@PathParam("id") UUID id) {
        if (todoDao.deleteTodo(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
} 