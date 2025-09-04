package com.mycompany.practicalassignment;
// contains all the logic for the series class. also contains helper methods.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class series {
//inner class that cointains a single tv series.
// each series has a name,id,age restiction and number of episodes.   
    public static class SeriesModel {
        private String seriesId;
        private String seriesName;
        private int seriesAge;
        private int seriesNumberOfEpisodes;
       // constructor which creating a new series object
        public SeriesModel(String id, String name, int age, int episodes) {
            this.seriesId = id;
            this.seriesName = name;
            this.seriesAge = age;
            this.seriesNumberOfEpisodes = episodes;
        }

        //getter
        public String getSeriesId() { return seriesId; }
        public String getSeriesName() { return seriesName; }
        public int getSeriesAge() { return seriesAge; }
        public int getSeriesNumberOfEpisodes() { return seriesNumberOfEpisodes; }
         //setters
        public void setSeriesName(String seriesName) { this.seriesName = seriesName; }
        public void setSeriesAge(int seriesAge) { this.seriesAge = seriesAge; }
        public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) { this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; }

        @Override
        public String toString() {
            return String.format("%-10s %-20s %-5d %-5d", seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
        }
    }
     // a collection of all captured series.
    private final List<SeriesModel> store = new ArrayList<>();
    private final Scanner scanner;

    
    public series(Scanner scanner) {
        this.scanner = scanner;
    }

   // validates the age. 
    public boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr.trim());
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
      // searches for a series by id.
    public SeriesModel searchSeriesById(String id) {
        for (SeriesModel s : store) {
            if (s.getSeriesId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    //callows user to cspture new series.
    public void captureSeries() {
        System.out.println("\n-- Capture New Series --");
         // checks unique id.
        String id;
        while (true) {
            System.out.print("Enter Series ID: ");
            id = scanner.nextLine().trim();
            if (searchSeriesById(id) == null) break;
            System.out.println("Series ID already exists. Enter a unique ID.");
        }
     // gets series name.
        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine().trim();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2-18): ");
            age = scanner.nextLine().trim();
            if (isValidAge(age)) break;
            System.out.println("Invalid age. Enter a number between 2 and 18.");
        }
         // checks number of episodes.
        int episodes;
        while (true) {
            System.out.print("Enter Number of Episodes: ");
            String epsStr = scanner.nextLine().trim();
            try {
                episodes = Integer.parseInt(epsStr);
                if (episodes > 0) break;
            } catch (NumberFormatException e) {}
            System.out.println("Invalid number. Enter a positive integer.");
        }
             // saves new series.
        store.add(new SeriesModel(id, name, Integer.parseInt(age), episodes));
        System.out.println("Series successfully saved!\n");
    }

    
    public void searchSeries() { // searches for a series.
        System.out.print("\nEnter Series ID: ");
        String id = scanner.nextLine().trim();
        SeriesModel s = searchSeriesById(id);
        if (s == null) {
            System.out.println("No series found.\n");
        } else {
            System.out.println("Found:");
            System.out.printf("%-10s %-20s %-5s %-5s\n", "ID", "Name", "Age", "Episodes");
            System.out.println(s + "\n");
        }
    }

   /**
     * Update an existing series by ID.
     * User can update name, age restriction, and number of episodes.
     */
    public void updateSeries() {
        System.out.print("\nEnter Series ID to update: ");
        String id = scanner.nextLine().trim();
        SeriesModel s = searchSeriesById(id);
        if (s == null) {
            System.out.println("No series found.\n");
            return;
        }
              // Update name.
        System.out.print("New Name (leave blank to keep): ");
        String name = scanner.nextLine().trim();
        if (!name.isBlank()) s.setSeriesName(name);
        // Update age restriction
        System.out.print("New Age (leave blank to keep): ");
        String ageStr = scanner.nextLine().trim();
        if (!ageStr.isBlank()) {
            if (isValidAge(ageStr)) {
                s.setSeriesAge(Integer.parseInt(ageStr));
            } else {
                System.out.println("Invalid age, keeping old value.");
            }
        }
        // Update number of episode.
        System.out.print("New Number of Episodes (leave blank to keep): ");
        String epsStr = scanner.nextLine().trim();
        if (!epsStr.isBlank()) {
            try {
                int episodes = Integer.parseInt(epsStr);
                if (episodes > 0) s.setSeriesNumberOfEpisodes(episodes);
                else System.out.println("Invalid number, keeping old value.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, keeping old value.");
            }
        }

        System.out.println("Series updated.\n");
    }
/**
     * Deletes a series by ID after confirming with the user.
     */
    
    public void deleteSeries() {
        System.out.print("\nEnter Series ID to delete: ");
        String id = scanner.nextLine().trim();
        SeriesModel s = searchSeriesById(id);
        if (s == null) {
            System.out.println("No series found.\n");
            return;
        }
        System.out.print("Confirm delete (Y/N): ");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("Y")) {
            store.remove(s);
            System.out.println("Series deleted.\n");
        } else {
            System.out.println("Delete cancelled.\n");
        }
    }

   //Displays a report of all captured series.
    public void seriesReport() {
        System.out.println("\n=== SERIES REPORT ===");
        if (store.isEmpty()) {
            System.out.println("No series available.\n");
            return;
        }
        System.out.printf("%-10s %-20s %-5s %-5s\n", "ID", "Name", "Age", "Episodes");
        for (SeriesModel s : store) {
            System.out.println(s);
        }
        System.out.println("Total series: " + store.size() + "\n");
    }

    /**
     * Exit message when application is closed.
     */
    public void exitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
    }

    
    public void addSeriesForTest(String id, String name, int age, int episodes) {
        store.add(new SeriesModel(id, name, age, episodes));
    }

    public boolean deleteSeriesByIdForTest(String id) {
        SeriesModel s = searchSeriesById(id);
        if (s != null) {
            store.remove(s);
            return true;
        }
        return false;
    }
}
