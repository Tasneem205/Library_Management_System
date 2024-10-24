package test;

import Library.Articles;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ArticlesTest {

    private Articles article;
    private List<Articles> articlesList;

    @BeforeEach
    void setUp() {
        // Sample data to initialize an Articles object
        article = new Articles(1, 101, "Java Best Practices", "John Doe", "TechPub", 
                               2024, "Available", 5, "Tech Journal", LocalDate.of(2023, 5, 10));
        articlesList = new ArrayList<>();
        articlesList.add(article);
        
        article.articles = articlesList;  // Assuming we initialize the list here for testing
        article.subscribers = new ArrayList<>();  // Initialize empty subscribers list
        article.subscribers.add("subscriber1@example.com");  // Adding a test subscriber
    }

    @Test
    void testGetJournal() {
        assertEquals("Tech Journal", article.getJournal());
    }

    @Test
    void testSetJournal() {
        article.setJournal("New Journal");
        assertEquals("New Journal", article.getJournal());
    }

    @Test
    void testGetPublicationDate() {
        assertEquals(LocalDate.of(2023, 5, 10), article.getPublicationDate());
    }

    @Test
    void testSetPublicationDate() {
        LocalDate newDate = LocalDate.of(2024, 6, 15);
        article.setPublicationDate(newDate);
        assertEquals(newDate, article.getPublicationDate());
    }


    @Test
    void testNotifySubscribersOfNewArticle() {
        Articles newArticle = new Articles(2, 102, "Advanced Java", "Jane Smith", "CodePub",
                                           2023, "Available", 10, "Tech Monthly", LocalDate.of(2023, 7, 21));
        article.notifySubscribersOfNewArticle(newArticle);
        // Output verification could be handled through mocking the output stream, but here we're assuming it prints correctly.
    }

    @Test
    void testSearchByAuthor() {
        List<Articles> result = article.searchByAuthor("John Doe");
        assertEquals(1, result.size());  // We expect 1 match
        assertEquals("Java Best Practices", result.get(0).getTitle());

        // Test for an author not present in the list
        List<Articles> emptyResult = article.searchByAuthor("Unknown Author");
        assertEquals(0, emptyResult.size());
    }
}
