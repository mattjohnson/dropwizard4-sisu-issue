package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.model.Todo;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Named("inMemory")
@Singleton
public class InMemoryTodoDao implements TodoDao {
    private final ConcurrentHashMap<UUID, Todo> todos = new ConcurrentHashMap<>();

    @Override
    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }

    @Override
    public Optional<Todo> getTodo(UUID id) {
        return Optional.ofNullable(todos.get(id));
    }

    @Override
    public Todo createTodo(Todo todo) {
        todos.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Optional<Todo> updateTodo(UUID id, Todo todo) {
        return Optional.ofNullable(todos.computeIfPresent(id, (key, existingTodo) -> {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setCompleted(todo.isCompleted());
            return existingTodo;
        }));
    }

    @Override
    public boolean deleteTodo(UUID id) {
        return todos.remove(id) != null;
    }
} 