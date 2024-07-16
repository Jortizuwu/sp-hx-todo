package com.hxa.todo.application.services.todo;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.domain.ports.in.todo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServices implements GetTodoUseCase, ListTodoUseCase, UpdateTodoUseCase, DeleteTodoUseCase, CreateTodoUseCase {

    private final CreateTodoUseCase createTodoUseCase;

    private final GetTodoUseCase getTodoUseCase;

    private final ListTodoUseCase listTodoUseCase;

    private final UpdateTodoUseCase updateTodoUseCase;

    private final DeleteTodoUseCase deleteTodoUseCase;

    public TodoServices(CreateTodoUseCase createTodoUseCase, GetTodoUseCase getTodoUseCase, ListTodoUseCase listTodoUseCase, UpdateTodoUseCase updateTodoUseCase, DeleteTodoUseCase deleteTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.getTodoUseCase = getTodoUseCase;
        this.listTodoUseCase = listTodoUseCase;
        this.updateTodoUseCase = updateTodoUseCase;
        this.deleteTodoUseCase = deleteTodoUseCase;
    }

    @Override
    public Todo createTodo(Todo body) {
        return this.createTodoUseCase.createTodo(body);
    }

    @Override
    public boolean deleteTodo(String id) {
        return this.deleteTodoUseCase.deleteTodo(id);
    }

    @Override
    public Optional<Todo> getTodo(String id) {
        return this.getTodoUseCase.getTodo(id);
    }

    @Override
    public List<Todo> listTodo() {
        return this.listTodoUseCase.listTodo();
    }

    @Override
    public Optional<Todo> updateTodo(String id, Todo body) {
        return this.updateTodoUseCase.updateTodo(id, body);
    }
}
