import java.util.Scanner;

/**
 * Main class containing menu handling and user input operations.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskService service = new TaskService();

    public static void main(String[] args) {
        new Main().startApplication();
    }

    /**
     * Application loop: displays menu and handles user input.
     */
    private void startApplication() {
        while (true) {
            printMenu();
            int option = readIntegerInput();

            try {
                processMenuSelection(option);
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    /**
     * Prints the available menu options.
     */
    private void printMenu() {
        System.out.println("\n===== Employee Task Tracker =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Processes the user's menu choice.
     */
    private void processMenuSelection(int option) throws Exception {
        switch (option) {
            case 1 -> handleAddTask();
            case 2 -> service.viewTasks();
            case 3 -> handleMarkCompleted();
            case 4 -> handleDeleteTask();
            case 5 -> exitApplication();
            default -> System.out.println("Invalid option. Try again.");
        }
    }

    /**
     * Handles adding a task with title and description.
     */
    private void handleAddTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description (optional): ");
        String description = scanner.nextLine();

        service.addTask(title, description);
    }

    /**
     * Handles marking task as completed.
     */
    private void handleMarkCompleted() throws TaskNotFoundException {
        System.out.print("Enter task ID to mark completed: ");
        int id = readIntegerInput();
        service.markTaskCompleted(id);
    }

    /**
     * Handles deleting a task.
     */
    private void handleDeleteTask() throws TaskNotFoundException {
        System.out.print("Enter task ID to delete: ");
        int id = readIntegerInput();
        service.deleteTask(id);
    }

    /**
     * Safely reads integer input without crashing.
     */
    private int readIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    /**
     * Clean application exit.
     */
    private void exitApplication() {
        System.out.println("Thank you for using Employee Task Tracker!");
        System.exit(0);
    }
}