public class StudentManagement {

    private StudentStack<Student> studentStack;

    public StudentManagement() {
        studentStack = new StudentStack<>();
    }

    public void addStudent(String id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Invalid Marks: Please enter marks between 0 and 10.");
            return;
        }
        StudentStack<Student> tempStack = new StudentStack<>();
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                System.out.println("Duplicate ID: A student with this ID already exists.");
                tempStack.push(student);
                while (!tempStack.isEmpty()) {
                    studentStack.push(tempStack.pop());
                }
                return;
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
        Student newStudent = new Student(id, name, marks);
        studentStack.push(newStudent);
        System.out.println("Student added successfully.");
    }

    public void editStudent(String id, String newName, double newMarks) {
        StudentStack<Student> tempStack = new StudentStack<>();
        boolean found = false;
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
        if (found) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(String id) {
        StudentStack<Student> tempStack = new StudentStack<>();
        boolean found = false;
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                found = true;
                continue;
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
        if (found) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void displayStudents() {
        if (studentStack.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Name", "Marks", "Rank");
        StudentStack<Student> tempStack = new StudentStack<>();
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            System.out.println(student);
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
    }

    public void sortStudentsBubbleSort() {
        if (studentStack.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }
        StudentStack<Student> sortedStack = new StudentStack<>();
        while (!studentStack.isEmpty()) {
            Student temp = studentStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek().getMarks() > temp.getMarks()) {
                studentStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        studentStack = sortedStack;
        System.out.println("Students sorted using Bubble Sort.");
    }

    public void sortStudentsQuickSort() {
        StudentStack<Student> tempStack = new StudentStack<>();
        while (!studentStack.isEmpty()) {
            tempStack.push(studentStack.pop());
        }
        Student[] studentArray = new Student[tempStack.size()];
        int index = 0;
        while (!tempStack.isEmpty()) {
            studentArray[index++] = tempStack.pop();
        }
        quickSort(studentArray, 0, studentArray.length - 1);
        for (Student student : studentArray) {
            studentStack.push(student);
        }
        System.out.println("Students sorted using Quick Sort.");
    }

    private void quickSort(Student[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(Student[] array, int low, int high) {
        double pivot = array[high].getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].getMarks() <= pivot) {
                i++;
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public void sortStudentsMergeSort() {
        StudentStack<Student> tempStack = new StudentStack<>();
        while (!studentStack.isEmpty()) {
            tempStack.push(studentStack.pop());
        }
        Student[] studentArray = new Student[tempStack.size()];
        int index = 0;
        while (!tempStack.isEmpty()) {
            studentArray[index++] = tempStack.pop();
        }
        mergeSort(studentArray, 0, studentArray.length - 1);
        for (Student student : studentArray) {
            studentStack.push(student);
        }
        System.out.println("Students sorted using Merge Sort.");
    }

    private void mergeSort(Student[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(Student[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() <= rightArray[j].getMarks()) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void searchStudent(String id) {
        StudentStack<Student> tempStack = new StudentStack<>();
        boolean found = false;
        Student foundStudent = null;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                found = true;
                foundStudent = student;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
