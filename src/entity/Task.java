package entity;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private Integer idTask;
    private String titleTask;
    private String descriptionTask;
    private String statusTask;
    private String priorityTask;
    private LocalDate dateTask;
    private User assignee;
    private List<Comment> comments;

    public Task(Integer idTask, String titleTask, String descriptionTask, String statusTask, String priorityTask, LocalDate dateTask, User assignee) {
        this.idTask = idTask;
        this.titleTask = titleTask;
        this.descriptionTask = descriptionTask;
        this.statusTask = statusTask;
        this.priorityTask = priorityTask;
        this.dateTask = dateTask;
        this.assignee = assignee;
        this.comments = new ArrayList<>();
    }
}
