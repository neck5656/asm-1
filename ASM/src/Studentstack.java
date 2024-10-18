class StudentStack {
    private Student[] stack; // Array to hold stack elements
    private int top;         // Index of the top element
    private int capacity;    // Maximum capacity of the stack

    // Constructor
    public StudentStack(int capacity) {
        this.capacity = capacity;
        stack = new Student[capacity]; // Initialize the stack array
        top = -1; // Stack is initially empty
    }

    // Push method to add a Student to the stack
    public void push(Student student) {
        if (top >= capacity - 1) {
            System.out.println("Stack overflow. Cannot push " + student);
        } else {
            stack[++top] = student; // Increment top and add student
            System.out.println("Pushed: " + student);
        }
    }

    // Pop method to remove and return the top Student from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop.");
            return null;
        } else {
            return stack[top--]; // Return top student and decrement top
        }
    }

    // Peek method to view the top Student without removing
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        } else {
            return stack[top]; // Return top student
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Stack is empty if top is -1
    }

    // Method to display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack contents: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " | ");
            }
            System.out.println();
        }
    }
}
