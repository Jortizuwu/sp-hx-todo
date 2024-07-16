package com.hxa.todo.infrastructure.adapters.todo.mappers;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.infrastructure.entities.todo.TodoEntity;

public interface TodoMapper {

    TodoEntity toEntity(Todo todo);

    Todo fromEntity(TodoEntity entity);

}