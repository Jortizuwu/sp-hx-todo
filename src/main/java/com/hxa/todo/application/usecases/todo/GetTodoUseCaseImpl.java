package com.hxa.todo.application.usecases.todo;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.domain.ports.in.todo.GetTodoUseCase;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;

import java.util.Optional;

public class GetTodoUseCaseImpl implements GetTodoUseCase {

    private final TodoRepositoryPort todoRepositoryPort;

    public GetTodoUseCaseImpl(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public Optional<Todo> getTodo(String id) {
        return this.todoRepositoryPort.findById(id);
    }
}
