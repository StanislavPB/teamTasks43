package Project.entity;


import java.util.List;

public class User {

    public enum Role {
        ADMIN, USER
    }

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private List<Message> messages;

    public User(Long id, String name, String email, String password, Role role, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.messages = messages;
    }

    public User(Long id, String name, String email, String password, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", messages=" + messages +
                '}';
    }
}