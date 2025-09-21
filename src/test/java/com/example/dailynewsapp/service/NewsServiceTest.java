package com.example.dailynewsapp.service;

import com.example.dailynewsapp.model.NewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {

    @InjectMocks
    private NewsService newsService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(newsService, "apiKey", "test-api-key");
        ReflectionTestUtils.setField(newsService, "apiUrl", "https://newsapi.org/v2/top-headlines");
    }

    @Test
    void newsService_ShouldBeInstantiated() {
        // When & Then
        assertNotNull(newsService);
    }

    @Test
    void newsService_ShouldHaveCorrectApiKey() {
        // When
        String apiKey = (String) ReflectionTestUtils.getField(newsService, "apiKey");
        
        // Then
        assertEquals("test-api-key", apiKey);
    }

    @Test
    void newsService_ShouldHaveCorrectApiUrl() {
        // When
        String apiUrl = (String) ReflectionTestUtils.getField(newsService, "apiUrl");
        
        // Then
        assertEquals("https://newsapi.org/v2/top-headlines", apiUrl);
    }
}