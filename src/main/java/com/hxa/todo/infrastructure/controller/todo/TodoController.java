package com.hxa.todo.infrastructure.controller.todo;

import com.hxa.todo.application.response.Response;
import com.hxa.todo.application.services.todo.TodoServices;
import com.hxa.todo.domain.models.Todo;
import com.hxa.todo.infrastructure.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoServices todoServices;

    public TodoController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    @GetMapping()
    public ResponseEntity<Response> listTodos(HttpServletRequest request) {
        List<Todo> todo = this.todoServices.listTodo();
        Response response = Response.build(200, request.getContextPath(), true, todo, false, getClientIp(request), "OK", HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getTodo(@PathVariable String id, HttpServletRequest request) {
        Todo todo = this.todoServices.getTodo(id).orElseThrow(() -> new ResourceNotFoundException(String.format("error todo with id: %s not found", id)));
        Response response = Response.build(200, request.getContextPath(), true, todo, false, getClientIp(request), "OK", HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Response> createTodo(@RequestBody Todo body, HttpServletRequest request) {
        Todo newtodo = this.todoServices.createTodo(body);
        Response response = Response.build(200, request.getContextPath(), true, newtodo, false, getClientIp(request), "OK", HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || remoteAddr.isEmpty()) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

}
