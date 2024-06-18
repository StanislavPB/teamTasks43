package repository;

import entity.Project;

import java.util.Optional;

public interface ProjectInterfaceRepository {

    Project addProject(Project project);

    boolean removeProject(Project project);

    Project findByProjectTitle(String projectTitle);

    Optional<Project> findByProjectId(Integer projectId);


}
