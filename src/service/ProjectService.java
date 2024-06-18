package service;

import dto.ProjectRequest;
import entity.Project;
import repository.ProjectRepository;
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean addNewProject(ProjectRequest request) {
        String title = request.getTitleOfProject();
        String description = request.getDescription();
        Long id = 0L;
        Project project = new Project(id,title,description);

        Project saveProject = projectRepository.addProject(project);

        if (saveProject.getId() >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
