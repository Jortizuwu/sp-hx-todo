package com.hxa.todo.domain.ports.in.todo;

import com.hxa.todo.domain.models.Todo;

import java.util.List;

public interface ListTodoUseCase {
    List<Todo> listTodo();
}
