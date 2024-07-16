package com.hxa.todo.application.usecases.todo;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.domain.ports.in.todo.CreateTodoUseCase;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;

public class CreateTodoUseCaseImpl implements CreateTodoUseCase {

    private final TodoRepositoryPort todoRepositoryPort;

    public CreateTodoUseCaseImpl(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public Todo createTodo(Todo body) {
        return this.todoRepositoryPort.save(body);
    }
}
