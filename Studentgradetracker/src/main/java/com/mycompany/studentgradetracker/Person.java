/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradetracker;

/**Person class
 * 
 *  Acts as a base (superclass) for Student.
 * Demonstrates encapsulation by keeping fields private and 
 *   exposing them through getters and setters.
 * Stores common attributes: name and ID.
 * 
 * This class will be extended by Student to add more functionality.
 * 
 * @author lab_services_student
 */


public class Person {
     // Fields (kept private for information hiding) 
    private String name;
    private String id;

    public Person(String name, String id) {  //Constructor for Person.
        this.name = name;
        this.id = id;
    }
       // Getters and setters (information hiding)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
