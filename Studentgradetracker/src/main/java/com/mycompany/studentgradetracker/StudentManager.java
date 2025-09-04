/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradetracker;

/*Stores and manages a list of Student objects.
 *  Provides functionality to add students and generate reports.
 *  Demonstrates the use of ArrayList, loops, and object interaction.
 *
 * @author lab_services_student
 */

import java.util.ArrayList;

public class StudentManager {
    // List to store all students
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) { //  Add a new student to the collection.
        students.add(s);
    }
    /**
     * generate and print a report of all students.
     * Includes:
     *  - Student ID
     *  - Student Name
     *  - Average mark
     *  - Highest mark
     *  - Lowest mark
     */

    public void report() {
        System.out.println("\n=== STUDENT REPORT ===");
        if (students.isEmpty()) { // Handle case when no students exist
            System.out.println("No students found.\n");
            return;
        }
        for (Student s : students) { // Print details of each student
            System.out.println("ID: " + s.getId() +
                    " | Name: " + s.getName() +
                    " | Avg: " + s.calculateAverage() +
                    " | High: " + s.getHighestMark() +
                    " | Low: " + s.getLowestMark());
        }
    }
     //Getter for the student list.
     //Useful for testing with JUnit.
    public ArrayList<Student> getStudents() {
        return students;
    }
}
