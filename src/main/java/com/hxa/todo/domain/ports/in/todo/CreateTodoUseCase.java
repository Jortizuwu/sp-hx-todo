package com.hxa.todo.domain.ports.in.todo;

import com.hxa.todo.domain.models.Todo;

public interface CreateTodoUseCase {

    Todo createTodo(Todo body);
}
