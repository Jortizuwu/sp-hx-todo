package com.hxa.todo.domain.ports.in.todo;

import com.hxa.todo.domain.models.Todo;

import java.util.Optional;

public interface UpdateTodoUseCase {

    Optional<Todo> updateTodo(String id, Todo body);

}
