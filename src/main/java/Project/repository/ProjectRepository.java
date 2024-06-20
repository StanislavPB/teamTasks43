package Project.repository;
import Project.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepository implements ProjectInterfaceRepository {
    private List<Project> projects = new ArrayList<>();
    private Long counter = 0L;

    @Override
    public Project addProject(Project project) {
        project.setId(++counter);
        projects.add(project);
        return project;
    }

    @Override
    public boolean removeProject(Long id) {
        return projects.remove(id);
    }

    @Override
    public Project findByProjectTitle(String projectTitle) {
        for (Project project : projects) {
            if (project.getTitle().equals(projectTitle)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public Optional<Project> findByProjectId(Integer projectId) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findByProjectId(Long projectId) {
        for (Project project : projects) {
            if (project.getId().equals(projectId)) {
                return Optional.of(project);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }

    public List<Project> findProjectsByUserId(Long userId) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.getMembers().contains(userId)) {
                result.add(project);
            }
        }
        return result;
    }
    public List<Long> findTeamMembersByProjectId(Long projectId) {
        // реализация поиска участников команды проекта по ID проекта
        for (Project project : projects) {
            if (project.getId().equals(projectId)) {
                return project.getMembers();
            }
        }
        return new ArrayList<>(); // возврат пустого списка, если проект не найден
    }
}
