package org.todo.todolist.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.todo.todolist.constant.ToDoStatus;
import org.todo.todolist.entity.ToDo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToDoRequest {

    private String title;
    private String desc;
    private ToDoStatus status;

    public ToDo toEntity() {
        return ToDo
                .builder()
                .title(this.title)
                .desc(this.desc)
                .status(this.status)
                .build();
    }

}
