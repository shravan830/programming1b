/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.studentgradetracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *Unit tests for the Student class.
 * These tests check that average, highest, and lowest marks are calculated correctly.
 * @author lab_services_student
 */

public class StudentTest {
     //Test that the calculateAverage() method correctly computes the average.
     // Expected average = (80 + 90 + 100) / 3 = 90.0
    

    @Test
    public void testAverage() {
        Student s = new Student("Alice", "S1", new int[]{80, 90, 100});
        assertEquals(90.0, s.calculateAverage(), 0.01);
        
       // Test that the getHighestMark() method correctly identifies the max value.
     // Highest value in {50, 75, 65} = 75
    }

    @Test
    public void testHighestMark() {
        Student s = new Student("Bob", "S2", new int[]{50, 75, 65});
        assertEquals(75, s.getHighestMark());
        
    }
    //Test that the getHighestMark() method correctly identifies the max value.
     // Highest value in {50, 75, 65} = 75

    @Test
    public void testLowestMark() {
        Student s = new Student("Charlie", "S3", new int[]{70, 40, 55});
        assertEquals(40, s.getLowestMark());
    }
}
