import java.util.ArrayList;
class StudentManagement {

    private ArrayList<Student> studentList;

    public StudentManagement() {
        studentList = new ArrayList<>();
    }

//    public void addStudent(String id, String name, double marks) {
//        Student newStudent = new Student(id, name, marks);
//        studentList.add(newStudent);
//        System.out.println("Student added successfully.");
//    }
    public void addStudent(String id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Invalid Marks: Please enter marks between 0 and 10.");
            return;
        }
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.println("Duplicate ID: A student with this ID already exists.");
                return;
            }
        }
        Student newStudent = new Student(id, name, marks);
        studentList.add(newStudent);
        System.out.println("Student added successfully.");
    }

    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }


    public void quickSort(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<Student> list, int low, int high) {
        double pivot = list.get(high).getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getMarks() >= pivot) { // Descending order
                i++;
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    public void sortStudents() {
        quickSort(studentList, 0, studentList.size() - 1);
        System.out.println("Students sorted by marks using Quick Sort.");
    }

    // Binary Search Implementation
    public Student binarySearch(String id) {
        int low = 0, high = studentList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Student midStudent = studentList.get(mid);
            if (midStudent.getId().equals(id)) {
                return midStudent;
            } else if (midStudent.getId().compareTo(id) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public void searchStudent(String id) {
        Student result = binarySearch(id);
        if (result != null) {
            System.out.println("Student Found: " + result);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Name", "Marks", "Rank");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}