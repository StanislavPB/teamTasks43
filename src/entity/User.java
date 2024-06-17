package entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer idUser;
    private String nameUser;
    private String passwordUser;
    private List<Project> projects;

    public User(Integer idUser, String nameUser, String passwordUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        this.projects = new ArrayList<>();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
