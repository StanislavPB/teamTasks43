package Project.repository;



import Project.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private Long counter = 0L;

    public Task addTask(Task task) {
        task.setId(++counter);
        tasks.add(task);
        return task;
    }

    public Optional<Task> findTaskById(Long taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst();
    }

    public List<Task> findTasksByUser(Long userId) {
        return tasks.stream()
                .filter(task -> task.getUsers().stream().anyMatch(user -> user.getId().equals(userId)))
                .collect(Collectors.toList());
    }

    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    public List<Task> findAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> findTasksByProjectId(Long projectId) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getProjectId().equals(projectId)) {
                result.add(task);
            }
        }
        return result;
    }

}

