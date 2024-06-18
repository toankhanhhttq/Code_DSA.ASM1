/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.Scanner;

/**
 *
 * @author DO KHANH TOAN
 */
public class StudentManagementSystem {
    private final Student[] students;
    private final int numStudents;
    private int top;

    public StudentManagementSystem(int numStudents) {
        this.numStudents = numStudents;
        this.students = new Student[numStudents];
        this.top = -1;
    }

    // Push (add) a student
    public void addStudent(Student student) {
        if (top == numStudents - 1) {
            System.out.println("Cannot add more students. Stack is full!");
            return;
        }
        students[++top] = student;
        System.out.println("Student added successfully!");
    }

    // Pop (remove) a student
    public Student removeStudent() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No student to remove.");
            return null;
        }
        Student removedStudent = students[top--];
        System.out.println("Student removed successfully!");
        return removedStudent;
    }

    // Peek (get the top student without removing)
    public Student peekStudent() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No student to peek.");
            return null;
        }
        return students[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Add functionality for editing a student
    public void editStudent(int id) {
        Scanner scanner = new Scanner(System.in);
        Student foundStudent = null;
        int index = -1;

        // Search for the student
        for (int i = 0; i <= top; i++) {
            if (students[i].getId() == id) {
                foundStudent = students[i];
                index = i;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println("Enter new details for student " + id);
            System.out.print("Name: ");
            foundStudent.setName(scanner.nextLine());
            System.out.print("Marks: ");
            foundStudent.setMarks(scanner.nextDouble());
            students[index] = foundStudent; // Update the student in the stack
            System.out.println("Student edited successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    // Add functionality for deleting a student
    public void deleteStudent(int id) {
        int index = -1;

        // Search for the student
        for (int i = 0; i <= top; i++) {
            if (students[i].getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < top; i++) {
                students[i] = students[i + 1];
            }
            students[top--] = null;
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    // Add functionality for sorting students
    public void sortStudents() {
        for (int i = 0; i < top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (students[i].getMarks() < students[j].getMarks()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Students sorted successfully!");
    }

    // Search for a student by ID
    public Student searchStudentById(int id) {
        for (int i = 0; i <= top; i++) {
            if (students[i].getId() == id) {
                System.out.println("Student found: " + students[i]);
                return students[i];
            }
        }
        System.out.println("Student with ID " + id + " not found!");
        return null;
    }

    // Add functionality to display all students
    public void displayAllStudents() {
        if (isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(students[i]);
        }
    }

}
