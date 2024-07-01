package org.todo.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.todo.todolist.dto.request.AddToDoRequest;
import org.todo.todolist.dto.request.UpdateToDoRequest;
import org.todo.todolist.dto.response.ToDoResponse;
import org.todo.todolist.entity.ToDo;
import org.todo.todolist.repository.ToDoRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo repo;

    @Transactional
    public ToDo get(Long id) {
        return repo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 투두리스트입니다!"));
    }

    @Transactional
    public List<ToDoResponse> getAll() {
        List<ToDo> todos = repo.findAll();
        return todos.stream().map(ToDoResponse::fromEntity).toList();
    }

    @Transactional
    public void add(AddToDoRequest request) {
        ToDo todo = request.toEntity();
        repo.save(todo);
    }

    @Transactional
    public void update(UpdateToDoRequest request) {
        ToDo todo = get(request.getId());
        todo.update(request);
    }

    @Transactional
    public void setConclude(List<Long> ids) {
        List<ToDo> todos = repo.findAllById(ids);
        todos.forEach(todo -> todo.toConcludeToDo());
    }

    @Transactional
    public void removeStatus(Long id) {
        ToDo todo = get(id);
        todo.toRemoved();
    }

}
