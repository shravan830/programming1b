package com.mycompany.practicalassignment;

import org.junit.jupiter.api.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for the Series class.
 * Covers validation, adding, searching, updating, and deleting.
 */
public class seriestest {

    private series app;  // Instance of the Series application
    /**
     * Runs before each test case.
     * Creates a new Series object with a fresh Scanner
     * so that each test starts with a clean setup.
     */

    @BeforeEach
    public void setUp() {
        /**
     * Test that isValidAge() accepts valid ages
     * within the range of 2 to 18.
     */
        
        app = new series(new Scanner(System.in));
    }

    @Test
    public void testIsValidAge_valid() {
        assertTrue(app.isValidAge("10"));
        assertTrue(app.isValidAge("2"));
        assertTrue(app.isValidAge("18"));
    }
     /**
     * Test that isValidAge() rejects invalid ages:
     * - too low (below 2)
     * - too high (above 18)
     * - non-numeric input
     * - empty string
     */
    @Test
    public void testIsValidAge_invalid() {
        assertFalse(app.isValidAge("1"));
        assertFalse(app.isValidAge("19"));
        assertFalse(app.isValidAge("abc"));
        assertFalse(app.isValidAge(""));
    }
          /**
     * Test adding a series and then finding it by ID.
     * Checks that the stored values (name, episodes) are correct.
     */
    @Test
    public void testAddAndSearchSeries() {
        app.addSeriesForTest("S1", "Naruto", 13, 220);
        series.SeriesModel s = app.searchSeriesById("S1");
        assertNotNull(s);
        assertEquals("Naruto", s.getSeriesName());
        assertEquals(220, s.getSeriesNumberOfEpisodes());
    }
         /**
     * Test searching for a series that does not exist.
     * Expected result: null (no series found).
     */
    @Test
    public void testSearchSeriesNotFound() {
        assertNull(app.searchSeriesById("DoesNotExist"));
    }
        /**
     * Test deleting a series that exists.
     * After deletion, searching for it should return null.
     */
    @Test
    public void testDeleteSeriesById_success() {
        app.addSeriesForTest("S2", "One Piece", 15, 1000);
        assertTrue(app.deleteSeriesByIdForTest("S2"));
        assertNull(app.searchSeriesById("S2"));
    }
 /**
     * Test deleting a series that does not exist.
     * Expected result: delete operation returns false.
     */
    @Test
    public void testDeleteSeriesById_fail() {
        assertFalse(app.deleteSeriesByIdForTest("XYZ"));
    }
    /**
     * Test updating values of an existing series.
     * Verifies that the updated values (name, age, episodes) are stored correctly.
     */
    @Test
    public void testUpdateSeries_keepValues() {
        app.addSeriesForTest("S3", "Bleach", 16, 366);
        series.SeriesModel s = app.searchSeriesById("S3");

         // Update values directly
        s.setSeriesName("Bleach Updated");
        s.setSeriesAge(17);
        s.setSeriesNumberOfEpisodes(400);

        assertEquals("Bleach Updated", s.getSeriesName());
        assertEquals(17, s.getSeriesAge());
        assertEquals(400, s.getSeriesNumberOfEpisodes());
    }
}
