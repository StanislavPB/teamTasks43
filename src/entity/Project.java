package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private Integer idProject;
    private String nameProject;
    private List<User> members;
    private List<Task> tasks;
    private LocalDate dateProject;

    public Project(Integer idProject, String nameProject, LocalDate dateProject) {
        this.idProject = idProject;
        this.nameProject = nameProject;
        this.members = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.dateProject = dateProject;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LocalDate getDateProject() {
        return dateProject;
    }
}