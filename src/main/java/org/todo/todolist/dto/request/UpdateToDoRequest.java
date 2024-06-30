package org.todo.todolist.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateToDoRequest {

    private Long id;
    private String title;
    private String desc;

}
