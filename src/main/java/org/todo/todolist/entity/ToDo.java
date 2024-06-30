package org.todo.todolist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.todo.todolist.constant.ToDoStatus;
import org.todo.todolist.dto.request.UpdateToDoRequest;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String desc;

    @Enumerated(EnumType.STRING)
    private ToDoStatus status;

    public void update(UpdateToDoRequest request) {
        this.title = request.getTitle();
        this.desc = request.getDesc();
    }

    public void toConcludeToDo() {
        toChangeStatus(ToDoStatus.CONCLUDE);
    }

    public void toRemoved() {
        toChangeStatus(ToDoStatus.REMOVED);
    }

    public void toProgress() {
        toChangeStatus(ToDoStatus.PROGRESS);
    }

    private void toChangeStatus(ToDoStatus status) {
        this.status = status;
    }

}
