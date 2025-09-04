/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgradetracker;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;
// main entry point for application
//features:
// add student
//view report of all students
//exit program
public class Studentgradetracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager(); // manages student list


        boolean running = true;
        while (running) {
            // Display Menu 
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1) Add Student");
            System.out.println("2) View Report");
            System.out.println("3) Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {  // Capture student details
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    int[] marks = new int[3];// Capture marks for 3 subjects into an array
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter mark " + (i + 1) + ": ");
                        marks[i] = Integer.parseInt(scanner.nextLine());
                    }
                         // Create a new Student object and add to manager
                    Student s = new Student(name, id, marks);
                    manager.addStudent(s);
                    System.out.println("✅ Student added.");
                }
                case "2" -> manager.report(); // Display report of students
                case "3" -> {
                    System.out.println("Exiting Student Tracker. Goodbye!");
                    running = false; // Exit loop
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close(); // Close scanner to avoid memory leaks
    }
}
