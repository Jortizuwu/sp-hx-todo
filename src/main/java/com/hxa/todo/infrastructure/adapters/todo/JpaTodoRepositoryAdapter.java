package com.hxa.todo.infrastructure.adapters.todo;

import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.domain.ports.out.todo.TodoRepositoryPort;
import com.hxa.todo.infrastructure.adapters.todo.mappers.TodoMapper;
import com.hxa.todo.infrastructure.entities.todo.TodoEntity;
import com.hxa.todo.infrastructure.repositories.todo.JpaTodoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTodoRepositoryAdapter implements TodoRepositoryPort {

    private final JpaTodoRepository jpaTodoRepository;

    private final TodoMapper todoMapper;

    public JpaTodoRepositoryAdapter(JpaTodoRepository jpaTodoRepository, TodoMapper todoMapper) {
        this.jpaTodoRepository = jpaTodoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public Optional<Todo> findById(String id) {

        Optional<TodoEntity> optionalTodoEntity = this.jpaTodoRepository.findById(id);

        if (optionalTodoEntity.isEmpty()) {
            return Optional.empty();
        }

        Todo todo = todoMapper.fromEntity(optionalTodoEntity.get());
        return Optional.of(todo);
    }

    @Override
    public List<Todo> findAll() {
        return this.jpaTodoRepository.findAll().stream().map(todoMapper::fromEntity).toList();
    }

    @Override
    public boolean deleteById(String id) {
        if (this.jpaTodoRepository.existsById(id)) {
            this.jpaTodoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Todo> updateTodo(String id, Todo body) {
        if (this.jpaTodoRepository.existsById(id)) {
            TodoEntity todoEntity = this.todoMapper.toEntity(body);
            TodoEntity todoUpdated = this.jpaTodoRepository.save(todoEntity);
            return Optional.of(this.todoMapper.fromEntity(todoUpdated));
        }
        return Optional.empty();

    }

    @Override
    public Todo save(Todo todo) {
        return this.todoMapper.fromEntity(this.jpaTodoRepository.save(todoMapper.toEntity(todo)));
    }
}
