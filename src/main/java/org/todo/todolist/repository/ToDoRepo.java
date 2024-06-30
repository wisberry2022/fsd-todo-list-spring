package org.todo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.todo.todolist.entity.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

}
