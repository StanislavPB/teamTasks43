package Project;

import Project.Service.*;
import Project.entity.*;
import Project.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static UserService userService;
    private static TaskService taskService;
    private static ProjectService projectService;
    private static CommentService commentService;
    private static MessageService messageService;

    public static void main(String[] args) {
        userService = new UserService(new UserRepository(),new TaskRepository(),new ProjectRepository());
        taskService = new TaskService(new TaskRepository());
        projectService = new ProjectService(new ProjectRepository());
        commentService = new CommentService(new CommentRepository());
        messageService = new MessageService(new MessageRepository());
        prepopulateData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            User authenticatedUser;
            try {
                authenticatedUser = userService.authenticateUser(email, password);
            } catch (IllegalArgumentException e) {
                System.out.println("Authentication failed: " + e.getMessage());
                continue;
            }

            if (authenticatedUser != null) {
                System.out.println("Welcome, " + authenticatedUser.getName() + "!");
                if (authenticatedUser.getRole() == User.Role.ADMIN) {
                    adminMenu(scanner, authenticatedUser);
                } else {
                    userMenu(scanner, authenticatedUser);
                }
            }
        }
    }

    private static void prepopulateData() {
        User admin = new User(null, "Admin", "admin@example.com", "admin", User.Role.ADMIN, new ArrayList<>());
        userService.createUser(admin);

        User user1 = new User(null, "User One", "user1@example.com", "password", User.Role.USER, new ArrayList<>());
        userService.createUser(user1);

        Project project1 = new Project(null, "название проекта", "Описание");
        projectService.addProject(project1);
    }

    private static void userMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. View Projects");
            System.out.println("2. View Tasks");
            System.out.println("3. Create Task");
            System.out.println("4. Update Task Status");
            System.out.println("5. Update Task Priority");
            System.out.println("6. View Project Team");
            System.out.println("7. View Comments");
            System.out.println("8. Add Comment");
            System.out.println("9. View Messages");
            System.out.println("10. Send Message");
//            System.out.println("11. Write to Admin");
            System.out.println("12. Logout");
            System.out.print("Select an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    viewProjects(user);
                    break;
                case 2:
                    viewTasks(user);
                    break;
                case 3:
                    createTask(scanner, user);
                    break;
                case 4:
                    updateTaskStatus(scanner, user);
                    break;
                case 5:
                    updateTaskPriority(scanner, user);
                    break;
                case 6:
                    viewProjectTeam(scanner, user);
                    break;
                case 7:
                    viewComments(scanner, user);
                    break;
                case 8:
                    addComment(scanner, user);
                    break;
                case 9:
                    viewMessages(user);
                    break;
                case 10:
                    sendMessage(scanner, user);
                    break;
//                case 11:
//                    writeToAdmin(scanner, user);
//                    break;
                case 12:
                    return; // Logout
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner, User admin) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View Projects");
            System.out.println("2. View Tasks");
            System.out.println("3. Create Task");
            System.out.println("4. Update Task Status");
            System.out.println("5. Update Task Priority");
            System.out.println("6. View Project Team");
            System.out.println("7. View Comments");
            System.out.println("8. Add Comment");
            System.out.println("9. View Messages");
            System.out.println("10. Send Message");
//            System.out.println("11. Write to Admin");
            System.out.println("12. Create User");
            System.out.println("13. Delete User");
            System.out.println("14. Create Project");
            System.out.println("15. Delete Project");
            System.out.println("16. Logout");
            System.out.print("Select an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    viewProjects(admin);
                    break;
                case 2:
                    viewTasks(admin);
                    break;
                case 3:
                    createTask(scanner, admin);
                    break;
                case 4:
                    updateTaskStatus(scanner, admin);
                    break;
                case 5:
                    updateTaskPriority(scanner, admin);
                    break;
                case 6:
                    viewProjectTeam(scanner, admin);
                    break;
                case 7:
                    viewComments(scanner, admin);
                    break;
                case 8:
                    addComment(scanner, admin);
                    break;
                case 9:
                    viewMessages(admin);
                    break;
                case 10:
                    sendMessage(scanner, admin);
                    break;
//                case 11:
//                    writeToAdmin(scanner, admin);
//                    break;
                case 12:
                    createUser(scanner);
                    break;
                case 13:
                    deleteUser(scanner);
                    break;
                case 14:
                    createProject(scanner);
                    break;
                case 15:
                    deleteProject(scanner);
                    break;
                case 16:
                    return; // Logout
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void viewProjects(User user) {
        List<Project> projects = projectService.getProjectsByUser(user.getId());
        for (Project project : projects) {
            System.out.println(project.getId());
        }
    }

    private static void viewTasks(User user) {
        List<Task> tasks = taskService.findTasksByUser(user.getId());
        for (Task task : tasks) {
            System.out.println(task.getTitle());
        }
    }

    private static void createTask(Scanner scanner, User user) {
        System.out.println("Enter task title: ");
        String title = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter task priority (LOW, MEDIUM, HIGH): ");
        Task.Priority priority = Task.Priority.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Enter task due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());

        Task task = new Task(null, user.getId(), title, description, priority, dueDate, Task.TaskStatus.NEW, new ArrayList<>(), user.getId(), new ArrayList<>());
        taskService.addTask(task);
        System.out.println("Task created successfully.");
    }

    private static void updateTaskStatus(Scanner scanner, User user) {
        System.out.println("Enter task ID: ");
        Long taskId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new status (NEW, IN_PROGRESS, CLOSED): ");
        Task.TaskStatus status = Task.TaskStatus.valueOf(scanner.nextLine().toUpperCase());

        taskService.updateTaskStatus(taskId, status);
        System.out.println("Task status updated successfully.");
    }

    private static void updateTaskPriority(Scanner scanner, User user) {
        System.out.println("Enter task ID: ");
        Long taskId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new priority (LOW, MEDIUM, HIGH): ");
        Task.Priority priority = Task.Priority.valueOf(scanner.nextLine().toUpperCase());

        taskService.updateTaskPriority(taskId, priority);
        System.out.println("Task priority updated successfully.");
    }

    private static void viewProjectTeam(Scanner scanner, User user) {
        System.out.println("Enter project ID: ");
        Long projectId = Long.parseLong(scanner.nextLine());
        List<Long> teamMembers = projectService.getTeamMembers(projectId);
        for (Long teamMember : teamMembers) {
            System.out.println(teamMember.getClass());
        }
    }

    private static void viewComments(Scanner scanner, User user) {
        System.out.println("Enter task ID: ");
        Long taskId = Long.parseLong(scanner.nextLine());
        List<Comment> comments = commentService.findAllCommentsByTaskId(taskId);
        for (Comment comment : comments) {
            System.out.println(comment.getContent());
        }
    }

    private static void addComment(Scanner scanner, User user) {
        System.out.println("Enter task ID: ");
        Long taskId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter comment content: ");
        String content = scanner.nextLine();
        commentService.addComment(taskId, user.getId(), content);
        System.out.println("Comment added successfully.");
    }

    private static void viewMessages(User user) {
        List<Message> messages = messageService.findMessagesByReceiver(user);
        for (Message message : messages) {
            System.out.println("From: " + message.getSenderId() + " - " + message.getContent());
        }
    }

    private static void sendMessage(Scanner scanner, User user) {
        System.out.println("Enter recipient email: ");
        String recipientEmail = scanner.nextLine();
        System.out.println("Enter message content: ");
        String content = scanner.nextLine();

        Optional<User> recipient = userService.findByEmail(recipientEmail);
        if (recipient.isPresent()) {
            Message message = new Message(null, user.getId(), recipient.get().getId(), content, LocalDateTime.now());
            messageService.addMessage(message);
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Recipient not found.");
        }
    }

//    private static void writeToAdmin(Scanner scanner, User user) {
//        System.out.println("Enter message to admin: ");
//        String content = scanner.nextLine();
//
//        Optional<User> admin = userService.getAdminUser();
//        if (admin.isPresent()) {
//            Message message = new Message(null, user.getId(), admin.get().getId(), content);
//            messageService.addMessage(message);
//            System.out.println("Message sent to admin successfully.");
//        } else {
//            System.out.println("Admin not found.");
//        }
//    }

    private static void createUser(Scanner scanner) {
        System.out.println("Enter user name: ");
        String name = scanner.nextLine();
        System.out.println("Enter user email: ");
        String email = scanner.nextLine();
        System.out.println("Enter user password: ");
        String password = scanner.nextLine();
        System.out.println("Enter user role (ADMIN/USER): ");
        User.Role role = User.Role.valueOf(scanner.nextLine().toUpperCase());

        User user = new User(null, name, email, password, role, new ArrayList<>());
        userService.createUser(user);
        System.out.println("User created successfully.");
    }

    private static void deleteUser(Scanner scanner) {
        System.out.println("Enter user ID: ");
        Long userId = Long.parseLong(scanner.nextLine());
        userService.deleteUser(userId);
        System.out.println("User deleted successfully.");
    }

    private static void createProject(Scanner scanner) {
        System.out.println("Enter project name: ");
        String name = scanner.nextLine();

        Project project = new Project(null,"название","описание");
        projectService.addProject(project);
        System.out.println("Project created successfully.");
    }

    private static void deleteProject(Scanner scanner) {
        System.out.println("Enter project ID: ");
        Long projectId = Long.parseLong(scanner.nextLine());
        projectService.removeProject(projectId);
        System.out.println("Project deleted successfully.");
    }
}
