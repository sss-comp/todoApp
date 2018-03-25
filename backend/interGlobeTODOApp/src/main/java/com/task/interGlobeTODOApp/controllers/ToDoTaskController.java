package com.task.interGlobeTODOApp.controllers;

import javax.validation.Valid;
import com.task.interGlobeTODOApp.model.ToDoTask;
import com.task.interGlobeTODOApp.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/************
 * @Desc: Controller which serve GET/POST http calls from client.
 * @Created on:24/03/2018
 * @Modified on:
 * @Created By: Sujit Shinde
 * *********/
@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class ToDoTaskController {

    @Autowired
    ToDoRepo todoRepository;

    @GetMapping("/todos")
    public List<ToDoTask> getAllTodos() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return todoRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/todos")
    public ToDoTask createTodo(@Valid @RequestBody ToDoTask todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @GetMapping(value="/todos/{id}")
    public ResponseEntity<ToDoTask> getTodoById(@PathVariable("id") String id) {
        return todoRepository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/todos/{id}")
    public ResponseEntity<ToDoTask> updateTodo(@PathVariable("id") String id,
                                           @Valid @RequestBody ToDoTask todo) {
        return todoRepository.findById(id)
                .map(todoData -> {
                    todoData.setTitle(todo.getTitle());
                    todoData.setCompleted(todo.getCompleted());
                    ToDoTask updatedTodo = todoRepository.save(todoData);
                    return ResponseEntity.ok().body(updatedTodo);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") String id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}