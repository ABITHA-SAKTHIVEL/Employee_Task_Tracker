/**
 * Represents an employee task with ID, title, description, and status.
 */
public class Task {

    private static int idCounter = 1;

    private final int taskId;
    private final String title;
    private final String description;
    private String status;

    public Task(String title, String description) {
        this.taskId = idCounter++;
        this.title = title;
        this.description = description != null ? description : "";
        this.status = "PENDING";
    }

    public int getTaskId() {
        return taskId;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.status = "COMPLETED";
    }

    @Override
    public String toString() {
        return "[" + taskId + "] " + title +
                " (" + status + ")" +
                (description.isEmpty() ? "" : " - " + description);
    }
}