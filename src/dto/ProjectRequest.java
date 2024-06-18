package dto;

public class ProjectRequest {
    private String titleOfProject;
    private String description;

    public ProjectRequest(String titleOfProject, String description) {
        this.titleOfProject = titleOfProject;
        this.description = description;
    }

    public String getTitleOfProject() {
        return titleOfProject;
    }

    public void setTitleOfProject(String titleOfProject) {
        this.titleOfProject = titleOfProject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "titleOfProject='" + titleOfProject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
