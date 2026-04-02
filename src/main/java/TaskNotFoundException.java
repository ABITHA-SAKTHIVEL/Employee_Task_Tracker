/**
 * Custom exception thrown when a task with a given ID is not found.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}