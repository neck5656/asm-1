import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement manager = new StudentManagement();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students");
            System.out.println("5. Search Student");
            System.out.println("6. Display Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input: Please enter a number between 1 and 7.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks (0-10): ");
                    try {
                        double marks = scanner.nextDouble();
                        manager.addStudent(id, name, marks);
                    } catch (Exception e) {
                        System.out.println("Invalid input: Marks must be a number.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Marks (0-10): ");
                    try {
                        double newMarks = scanner.nextDouble();
                        manager.editStudent(editId, newName, newMarks);
                    } catch (Exception e) {
                        System.out.println("Invalid input: Marks must be a number.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteStudent(deleteId);
                    break;

                case 4:
                    System.out.println("Sort Options:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Quick Sort");
                    System.out.println("3. Merge Sort");
                    System.out.print("Choose sorting method: ");
                    int sortChoice;
                    try {
                        sortChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sortChoice) {
                            case 1:
                                manager.sortStudentsBubbleSort();
                                break;
                            case 2:
                                manager.sortStudentsQuickSort();
                                break;
                            case 3:
                                manager.sortStudentsMergeSort();
                                break;
                            default:
                                System.out.println("Invalid sorting choice.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input: Please enter a valid sorting option.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    manager.searchStudent(searchId);
                    break;

                case 6:
                    manager.displayStudents();
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
