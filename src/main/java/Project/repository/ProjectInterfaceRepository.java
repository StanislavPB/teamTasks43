package Project.repository;
import Project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectInterfaceRepository {

    Project addProject(Project project);


    boolean removeProject(Long id);

    Project findByProjectTitle(String projectTitle);

    Optional<Project> findByProjectId(Integer projectId);


    Optional<Project> findByProjectId(Long projectId);

    List<Project> getAllProjects();
}
