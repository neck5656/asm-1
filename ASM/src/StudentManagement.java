import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class StudentManagement {
    private ArrayList<Student> students; // List to hold Student objects

    // Constructor
    public StudentManagement() {
        students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added: " + student);
    }

    // Method to delete a student by ID
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Deleted student with ID: " + id);
    }

    // Method to update student information
    public void updateStudent(int id, String name, double marks) {
        for (Student student : students) {
            if (student.getId() == id) {
                // Assuming we create a new Student object for the update
                deleteStudent(id);
                addStudent(new Student(id, name, marks));
                System.out.println("Updated student with ID: " + id);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to search for a student by ID
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Found: " + student);
                return student;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

    // Method to sort students by marks
    public void sortStudentsByMarks() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks.");
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
