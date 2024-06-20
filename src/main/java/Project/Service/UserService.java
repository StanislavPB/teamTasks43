package Project.Service;

import Project.entity.Task;
import Project.entity.User;
import Project.entity.Project;
import Project.repository.ProjectRepository;
import Project.repository.TaskRepository;
import Project.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }



    public User createUser(User user) {
        validateUser(user);
        return userRepository.save(user);
    }

    private void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email не может быть пустым или null");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password не может быть пустым или равен null");
        }
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(userRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден")));
    }

    public User updateUser(User user) {
        validateUser(user);
        return userRepository.updateUser(user);
    }

    public boolean deleteUser(Long id) {
        System.out.println("Удаление пользователя " + id);
        boolean deleted = userRepository.deleteUser(id);
        if (!deleted) {
            throw new IllegalArgumentException("Пользователь с таким id: " + id + " не найден");
        }
        return deleted;
    }

    public List<User> findAllUsersByTask(Long taskId) {
        Task task = taskRepository.findTaskById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Задача не найдена"));
        return task.getUsers();
    }

    public List<User> getTeamMembers(Long projectId) {
        Project project = projectRepository.findByProjectId(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден"));
        return project.getMembers(); // Предполагается, что getMembers() возвращает List<User>
    }

    public User authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> getAdminUser() {
        return userRepository.findByRole(User.Role.ADMIN);
    }
}
