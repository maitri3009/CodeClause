import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bug {
    private String description;
    private String status;

    public Bug(String description) {
        this.description = description;
        this.status = "Open";
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class BugTracker {
    private List<Bug> bugs;

    public BugTracker() {
        this.bugs = new ArrayList<>();
    }

    public void reportBug(String description) {
        Bug bug = new Bug(description);
        bugs.add(bug);
        System.out.println("Bug reported successfully.");
    }

    public void viewBugs() {
        System.out.println("\nBugs in the system:");
        for (Bug bug : bugs) {
            System.out.println("Description: " + bug.getDescription() + ", Status: " + bug.getStatus());
        }
    }

    public void updateBugStatus(int bugIndex, String newStatus) {
        if (bugIndex >= 0 && bugIndex < bugs.size()) {
            Bug bug = bugs.get(bugIndex);
            bug.setStatus(newStatus);
            System.out.println("Bug status updated successfully.");
        } else {
            System.out.println("Invalid bug index.");
        }
    }
}

public class BugTrackingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BugTracker bugTracker = new BugTracker();

        while (true) {
            System.out.println("\n1. Report Bug\n2. View Bugs\n3. Update Bug Status\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter bug description: ");
                    scanner.nextLine(); // Consume the newline character
                    String description = scanner.nextLine();
                    bugTracker.reportBug(description);
                    break;

                case 2:
                    bugTracker.viewBugs();
                    break;

                case 3:
                    try {
                        System.out.print("Enter the index of the bug to update: ");
                        int bugIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter the new status: ");
                        String newStatus = scanner.nextLine();
                        bugTracker.updateBugStatus(bugIndex, newStatus);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for the bug index.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Bug Tracking System. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}