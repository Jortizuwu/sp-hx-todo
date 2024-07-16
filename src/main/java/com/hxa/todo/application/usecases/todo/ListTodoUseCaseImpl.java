package com.hxa.todo.application.usecases.todo;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.domain.ports.in.todo.ListTodoUseCase;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;

import java.util.List;

public class ListTodoUseCaseImpl implements ListTodoUseCase {

    private final TodoRepositoryPort todoRepositoryPort;

    public ListTodoUseCaseImpl(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public List<Todo> listTodo() {
        return this.todoRepositoryPort.findAll();
    }
}
