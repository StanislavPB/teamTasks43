package Project.entity;

import java.time.LocalDate;
import java.util.List;

public class Task {
    public enum Priority{
        LOW,MEDIUM,HARD
    }
    public enum TaskStatus{
        NEW,IN_PROGRESS,CLOSED
    }

    private Long id;
    private Long projectId;
    private String title;
    private String description;
    private Priority priority;
    private LocalDate dueDate;
    private TaskStatus status;
    private Long assignedTo;
    private Long createdBy;
    private List<Comment> comments;

    public Task(Long id, Long projectId, String title, String description, Priority priority, LocalDate dueDate, TaskStatus status, Long assignedTo, Long createdBy, List<Comment> comments) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdBy = createdBy;
        this.comments = comments;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
