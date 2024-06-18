package org;

import entity.Project;
import repository.ProjectRepository;
import service.ProjectService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ProjectRepository repository = new ProjectRepository();
        ProjectService service = new ProjectService(repository);

        Project project1 = new Project(12L,"Project1","easy");
        Project project2 = new Project(1L,"Project2","hard");
        Project project3 = new Project(13L,"Project3","easy");



    }
}
