package com.hxa.todo.application.usecases.todo;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.domain.ports.in.todo.UpdateTodoUseCase;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;

import java.util.Optional;

public class UpdateTodoUseCaseImpl implements UpdateTodoUseCase {

    private final TodoRepositoryPort todoRepositoryPort;

    public UpdateTodoUseCaseImpl(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public Optional<Todo> updateTodo(String id, Todo body) {
        return this.todoRepositoryPort.updateTodo(id, body);
    }
}
