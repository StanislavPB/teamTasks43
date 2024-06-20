package Project.Service;

import Project.entity.Project;
import Project.entity.Task;
import Project.entity.User;
import Project.repository.ProjectRepository;
import Project.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class ProjectService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        return projectRepository.addProject(project);
    }

    public boolean removeProject(Long id) {
        return projectRepository.removeProject(id);
    }

    public Project findByProjectTitle(String projectTitle) {
        return projectRepository.findByProjectTitle(projectTitle);
    }

    public Optional<Project> findByProjectId(Long projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    public List<Project> getProjectsByUser(Long userId) {
        return projectRepository.findProjectsByUserId(userId);
    }
    public List<User> getTeamMembers(Long projectId) {
        return projectRepository.findTeamMembersByProjectId(projectId);
    }
    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findTasksByProjectId(projectId);
    }
    }


