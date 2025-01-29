package com.example.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Todo;

public interface TodoDao {
    List<Todo> getAllTodos();
    Optional<Todo> getTodo(UUID id);
    Todo createTodo(Todo todo);
    Optional<Todo> updateTodo(UUID id, Todo todo);
    boolean deleteTodo(UUID id);
} 