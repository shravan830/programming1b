/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicalassignment;

import java.util.Scanner; // i have to import because im using scanner 
// this is my main class this handles the main menu and user interaction
public class Practicalassignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // creating scanner for my user inputs
        series app = new series(scanner);

        boolean running = true; // this loops until use chooses to exit
        while (running) {
            // this is the menu
            System.out.println("===== TV SERIES MENU =====");
            System.out.println("1) Capture Series");
            System.out.println("2) Search Series");
            System.out.println("3) Update Series");
            System.out.println("4) Delete Series");
            System.out.println("5) View Report");
            System.out.println("6) Exit");
            System.out.print("Choose option: ");
              // this reads the user inputs
            String choice = scanner.nextLine().trim();
            switch (choice) { //handles user choice using switch statements
                case "1" -> app.captureSeries();
                case "2" -> app.searchSeries();
                case "3" -> app.updateSeries();
                case "4" -> app.deleteSeries();
                case "5" -> app.seriesReport();
                case "6" -> {
                    app.exitSeriesApplication(); // will exit the applicstion
                    running = false;              // this end the loop
                }
                default -> System.out.println("Invalid choice.\n"); // will show if you used wrong input
            }
        }
        scanner.close(); // closes the scanner before you leave
    }
}
