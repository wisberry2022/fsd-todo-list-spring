package org.todo.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.todolist.dto.request.AddToDoRequest;
import org.todo.todolist.dto.request.UpdateToDoRequest;
import org.todo.todolist.dto.response.ToDoResponse;
import org.todo.todolist.service.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService service;

    @GetMapping
    public ResponseEntity<List<ToDoResponse>> getAll() {
        List<ToDoResponse> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody AddToDoRequest request) {
        service.add(request);
        return ResponseEntity.ok().body("추가되었습니다!");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UpdateToDoRequest request) {
        service.update(request);
        return ResponseEntity.ok().body("수정되었습니다!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        service.removeStatus(id);
        return ResponseEntity.ok().body("삭제되었습니다!");
    }

}


