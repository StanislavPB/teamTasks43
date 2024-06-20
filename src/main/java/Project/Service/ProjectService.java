package Project.Service;

import Project.entity.Project;
import Project.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

public class ProjectService {
    private ProjectRepository projectRepository;

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
    public List<Long> getTeamMembers(Long projectId) {
        return projectRepository.findTeamMembersByProjectId(projectId);
    }
    }


