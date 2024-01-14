package net.hinecora.jwttaskmanager.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskRequest {

    private Integer id;
    private String title;
    private String description;
    private String author;
    private String executor;
    private Priority priority;
    private Status status;
}
