package com.hxa.todo.domain.ports.in.todo;

import com.hxa.todo.domain.models.Todo;

import java.util.Optional;

public interface GetTodoUseCase {
    Optional<Todo> getTodo(String id);
}
