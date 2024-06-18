package repository;

import entity.Project;

import java.util.List;
import java.util.Optional;

public class ProjectRepository implements ProjectInterfaceRepository {

    private List<Project> projects;
    private Long counter = 0L;

    public ProjectRepository() {
        this.projects = projects;
    }

    @Override
    public Project addProject(Project project) {
        project.setId(++counter);
        projects.add(project);
        return project;
    }

    @Override
    public boolean removeProject(Project project) {
        return projects.remove(project);

    }

    @Override
    public Project findByProjectTitle(String projectTitle) {
        for (Project project : projects) {
            if (project.getTitle().equals(projectTitle)) ;
            return project;
        }
        return null;
    }

    @Override
    public Optional<Project> findByProjectId(Integer projectId) {
        for (Project project : projects) {
            if (project.getId().equals(projectId)) ;
            return Optional.of(project);
        }
        return Optional.empty();
    }
}
