package com.hxa.todo.application.usecases.todo;

import com.hxa.todo.domain.ports.in.todo.DeleteTodoUseCase;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;

public class DeleteTodoUseCaseImpl implements DeleteTodoUseCase {

    private final TodoRepositoryPort todoRepositoryPort;

    public DeleteTodoUseCaseImpl(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public boolean deleteTodo(String id) {
        return this.todoRepositoryPort.deleteById(id);
    }
}
