package org.todo.todolist.dto.response;

import lombok.*;
import org.todo.todolist.constant.ToDoStatus;
import org.todo.todolist.entity.ToDo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoResponse {

    private Long id;
    private String title;
    private String desc;
    private ToDoStatus status;

    public static ToDoResponse fromEntity(ToDo entity) {
        return ToDoResponse
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .desc(entity.getDesc())
                .status(entity.getStatus())
                .build();
    }

}
