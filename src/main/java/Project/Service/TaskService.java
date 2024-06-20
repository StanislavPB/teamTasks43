package Project.Service;



import Project.entity.Task;
import Project.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        return taskRepository.addTask(task);
    }

    public Optional<Task> findTaskById(Long taskId) {
        return taskRepository.findTaskById(taskId);
    }

    public List<Task> findTasksByUser(Long userId) {
        return taskRepository.findTasksByUser(userId);
    }

    public boolean removeTask(Task task) {
        return taskRepository.removeTask(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAllTasks();
    }

    public List<Task> findTasksByProject(Long projectId) {
        return taskRepository.findTasksByProject(projectId);
    }

    public Task updateTaskPriority(Long taskId, Task.Priority priority) {
        Task task = taskRepository.findTaskById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setPriority(priority);
        return task;
    }

    public Task updateTaskStatus(Long taskId, Task.TaskStatus status) {
        Task task = taskRepository.findTaskById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setStatus(status);
        return task;
    }
}

