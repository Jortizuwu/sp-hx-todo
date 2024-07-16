package com.hxa.todo.infrastructure.repositories.todo;

import com.hxa.todo.infrastructure.entities.todo.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTodoRepository extends JpaRepository<TodoEntity, String> {
}
