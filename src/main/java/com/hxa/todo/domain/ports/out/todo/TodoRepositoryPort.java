package com.hxa.todo.domain.ports.out.todo;

import com.hxa.todo.domain.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepositoryPort {

    Optional<Todo> findById(String id);

    List<Todo> findAll();

    boolean deleteById(String id);

    Optional<Todo> updateTodo(String id, Todo body);

    Todo save(Todo todo);

}
