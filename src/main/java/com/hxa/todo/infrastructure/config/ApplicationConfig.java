package com.hxa.todo.infrastructure.config;

import com.hxa.todo.application.services.todo.TodoServices;
import com.hxa.todo.application.usecases.todo.*;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;
import com.hxa.todo.infrastructure.adapters.todo.JpaTodoRepositoryAdapter;
import com.hxa.todo.infrastructure.adapters.todo.mappers.TodoMapper;
import com.hxa.todo.infrastructure.adapters.todo.mappers.TodoMapperAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TodoServices todoServices(TodoRepositoryPort todoRepositoryPort) {
        return new TodoServices(new CreateTodoUseCaseImpl(todoRepositoryPort), new GetTodoUseCaseImpl(todoRepositoryPort), new ListTodoUseCaseImpl(todoRepositoryPort), new UpdateTodoUseCaseImpl(todoRepositoryPort), new DeleteTodoUseCaseImpl(todoRepositoryPort));
    }

    @Bean
    public TodoRepositoryPort todoRepositoryPort(JpaTodoRepositoryAdapter jpaTodoRepositoryAdapter) {
        return jpaTodoRepositoryAdapter;
    }

    @Bean
    public TodoMapper todoMapper() {
        return new TodoMapperAdapter();
    }


}