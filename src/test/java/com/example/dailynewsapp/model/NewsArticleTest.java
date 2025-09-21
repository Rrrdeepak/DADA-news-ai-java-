package com.example.dailynewsapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsArticleTest {

    private NewsArticle newsArticle;

    @BeforeEach
    void setUp() {
        newsArticle = new NewsArticle();
    }

    @Test
    void testGettersAndSetters() {
        // Given
        String title = "Test News Title";
        String description = "Test news description";
        String url = "https://example.com/news";
        String urlToImage = "https://example.com/image.jpg";
        String publishedAt = "2024-01-01T10:00:00Z";
        String author = "Test Author";
        Source source = new Source();
        source.setId("test-source");
        source.setName("Test Source");

        // When
        newsArticle.setTitle(title);
        newsArticle.setDescription(description);
        newsArticle.setUrl(url);
        newsArticle.setUrlToImage(urlToImage);
        newsArticle.setPublishedAt(publishedAt);
        newsArticle.setAuthor(author);
        newsArticle.setSource(source);

        // Then
        assertEquals(title, newsArticle.getTitle());
        assertEquals(description, newsArticle.getDescription());
        assertEquals(url, newsArticle.getUrl());
        assertEquals(urlToImage, newsArticle.getUrlToImage());
        assertEquals(publishedAt, newsArticle.getPublishedAt());
        assertEquals(author, newsArticle.getAuthor());
        assertEquals(source, newsArticle.getSource());
    }

    @Test
    void testDefaultConstructor() {
        // When
        NewsArticle article = new NewsArticle();

        // Then
        assertNotNull(article);
        assertNull(article.getTitle());
        assertNull(article.getDescription());
        assertNull(article.getUrl());
        assertNull(article.getUrlToImage());
        assertNull(article.getPublishedAt());
        assertNull(article.getAuthor());
        assertNull(article.getSource());
    }
}
