import java.util.Scanner;

class Student {
    String name;
    int classNumber;
    double tuitionFee;
    double booksFee;

    public Student(String name, int classNumber, double tuitionFee, double booksFee) {
        this.name = name;
        this.classNumber = classNumber;
        this.tuitionFee = tuitionFee;
        this.booksFee = booksFee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classNumber=" + classNumber +
                ", tuitionFee=" + tuitionFee +
                ", booksFee=" + booksFee +
                '}';
    }
}

class FeeReport {
    private static final int MAX_STUDENTS = 100;
    private Student[] students;
    private int studentCount;

    public FeeReport() {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount++] = student;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Cannot add more students. Maximum limit reached.");
        }
    }

    public void generateReport() {
        System.out.println("\nFee Report:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Student " + (i + 1) + ": " + students[i]);
        }
    }
}

public class FeeReportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeeReport feeReport = new FeeReport();

        while (true) {
            System.out.println("\n1. Add Student\n2. Generate Fee Report\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter class number: ");
                    int classNumber = scanner.nextInt();
                    System.out.print("Enter tuition fee: ");
                    double tuitionFee = scanner.nextDouble();
                    System.out.print("Enter books fee: ");
                    double booksFee = scanner.nextDouble();

                    Student newStudent = new Student(name, classNumber, tuitionFee, booksFee);
                    feeReport.addStudent(newStudent);
                    break;

                case 2:
                    feeReport.generateReport();
                    break;

                case 3:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}