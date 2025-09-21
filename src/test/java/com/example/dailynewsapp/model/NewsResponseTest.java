package com.example.dailynewsapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsResponseTest {

    private NewsResponse newsResponse;

    @BeforeEach
    void setUp() {
        newsResponse = new NewsResponse();
    }

    @Test
    void testGettersAndSetters() {
        // Given
        String status = "ok";
        int totalResults = 10;
        List<NewsArticle> articles = Arrays.asList(new NewsArticle(), new NewsArticle());

        // When
        newsResponse.setStatus(status);
        newsResponse.setTotalResults(totalResults);
        newsResponse.setArticles(articles);

        // Then
        assertEquals(status, newsResponse.getStatus());
        assertEquals(totalResults, newsResponse.getTotalResults());
        assertEquals(articles, newsResponse.getArticles());
        assertEquals(2, newsResponse.getArticles().size());
    }

    @Test
    void testDefaultConstructor() {
        // When
        NewsResponse response = new NewsResponse();

        // Then
        assertNotNull(response);
        assertNull(response.getStatus());
        assertEquals(0, response.getTotalResults());
        assertNull(response.getArticles());
    }
}
