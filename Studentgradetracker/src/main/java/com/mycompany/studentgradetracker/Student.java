/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradetracker;

/**Student class
 * 
 *  Inherits from Person (demonstrates inheritance).
 *  Stores an array of marks (demonstrates arrays).
 * Includes methods to calculate average, highest, and lowest marks (loops).
 *  Demonstrates constructors and encapsulation.
 * 
 * This class represents a single student with their academic performance.
 *
 * @author lab_services_student
 */


public class Student extends Person {
    private int[] marks;  // array of subject marks
    
    
      //Constructor for Student.
     //Calls the superclass (Person) constructor for name and ID.
      //Initializes the marks array.

    public Student(String name, String id, int[] marks) {
        super(name, id);
        this.marks = marks;
    }
      /**
     * Calculate the average of all marks.
     * Uses a loop to sum the marks.
     *
     * @return average value of marks
     */
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m; // loop through marks array
        return (double) sum / marks.length;
    }
    

    public int getHighestMark() {
        int max = marks[0];
        for (int m : marks) if (m > max) max = m;
        return max;
    }

    public int getLowestMark() {
        int min = marks[0];
        for (int m : marks) if (m < min) min = m;
        return min;
    }

    public int[] getMarks() { return marks; }
}
