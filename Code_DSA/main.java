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
public class main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of students: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            StudentManagementSystem system = new StudentManagementSystem(numStudents);

            int choice;
            do {
                // Display the menu
                System.out.println("\n" + "=".repeat(30));
                System.out.println("       Student Management System by Toan      ");
                System.out.println("=".repeat(30));
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Edit Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Sort Students");
                System.out.println("6. Search Student by ID");
                System.out.println("7. Display Students");
                System.out.println("8. Exit");
                System.out.println("=".repeat(30));
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student marks: ");
                        double marks = scanner.nextDouble();
                        system.addStudent(new Student(id, name, marks));
                    }
                    case 2 -> system.removeStudent();
                    case 3 -> {
                        System.out.print("Enter student ID to edit: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        system.editStudent(id);
                    }
                    case 4 -> {
                        System.out.print("Enter student ID to delete: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        system.deleteStudent(id);
                    }
                    case 5 -> system.sortStudents();
                    case 6 -> {
                        System.out.print("Enter student ID to search: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        system.searchStudentById(id);
                    }
                    case 7 -> system.displayAllStudents();
                    case 8 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 8);
        }
    }
}
