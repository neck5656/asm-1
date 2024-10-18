public class Main {
    public static void main(String[] args) {
        // Create the student management system
        StudentManagement studentManagement = new StudentManagement();

        // Create a student stack with a capacity of 5
        StudentStack studentStack = new StudentStack(5);

        // Adding students
        studentManagement.addStudent(new Student(1, "Truong", 8.0));
        studentManagement.addStudent(new Student(2, "Nghia", 8.8));
        studentManagement.addStudent(new Student(3, "Viet", 9.2));


        // Display all students
        studentManagement.displayAllStudents();

        // Searching for a student
        studentManagement.searchStudent(2);

        // Updating a student
        studentManagement.updateStudent(4, "Trieu", 7.5);
        studentManagement.displayAllStudents();

        // Deleting a student
        studentManagement.deleteStudent(1);
        studentManagement.displayAllStudents();

        // Pushing students onto the stack
        studentStack.push(new Student(1, "Truong", 8.5));
        studentStack.push(new Student(2, "Nghia", 7.0));
        studentStack.push(new Student(3, "Viet", 9.2));


        // Displaying stack contents
        studentStack.display();

        // Peek at the top student
        System.out.println("Peeked: " + studentStack.peek());

        // Pop a student from the stack
        studentStack.pop();
        studentStack.display();
    }
}
