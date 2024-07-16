package com.hxa.todo.infrastructure.adapters.todo.mappers;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.infrastructure.entities.todo.TodoEntity;

public class TodoMapperAdapter implements TodoMapper {

    public TodoEntity toEntity(Todo todo) {
        return TodoEntity.build(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isDone(), todo.getCreatedAt(), todo.getUpdatedAt());

    }

    public Todo fromEntity(TodoEntity entity) {
        return Todo.build(entity.getId(), entity.getTitle(), entity.getDescription(), entity.isDone(), entity.getCreatedAt(), entity.getUpdatedAt());
    }

}
