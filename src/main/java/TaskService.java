import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing employee tasks.
 * Contains operations for adding, viewing, updating, and deleting tasks.
 */
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    /**
     * Adds a new task after validating title.
     */
    public void addTask(String title, String description) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty.");
        }

        Task task = new Task(title.trim(), description);
        tasks.add(task);
        System.out.println("✅ Task added successfully. ID = " + task.getTaskId());
    }

    /**
     * Displays all tasks.
     */
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\n===== Task List =====");
        tasks.forEach(System.out::println);
    }

    /**
     * Marks a task as completed.
     */
    public void markTaskCompleted(int taskId) throws TaskNotFoundException {
        Task task = findTaskById(taskId);

        if ("COMPLETED".equals(task.getStatus())) {
            System.out.println("Task is already completed.");
            return;
        }

        task.markCompleted();
        System.out.println("✅ Task marked as completed.");
    }

    /**
     * Deletes a task by ID.
     */
    public void deleteTask(int taskId) throws TaskNotFoundException {
        Task task = findTaskById(taskId);
        tasks.remove(task);
        System.out.println("✅ Task deleted successfully.");
    }

    /**
     * Finds a task by ID or throws exception.
     */
    private Task findTaskById(int taskId) throws TaskNotFoundException {
        return tasks.stream()
                .filter(task -> task.getTaskId() == taskId)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task ID not found: " + taskId));
    }
}