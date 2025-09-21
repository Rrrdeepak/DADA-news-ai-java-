package com.example.dailynewsapp.controller;

import com.example.dailynewsapp.model.NewsArticle;
import com.example.dailynewsapp.model.NewsResponse;
import com.example.dailynewsapp.model.Source;
import com.example.dailynewsapp.service.NewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class NewsControllerTest {

    @Mock
    private NewsService newsService;

    @InjectMocks
    private NewsController newsController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(newsController).build();
    }

    @Test
    void home_ShouldReturnIndexViewWithNews() throws Exception {
        // Given
        NewsResponse newsResponse = createMockNewsResponse();
        when(newsService.getTopHeadlines()).thenReturn(Mono.just(newsResponse));

        // When & Then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("news", newsResponse))
                .andExpect(model().attribute("category", "All News"));
    }

    @Test
    void home_WhenServiceThrowsException_ShouldReturnIndexWithError() throws Exception {
        // Given
        when(newsService.getTopHeadlines()).thenReturn(Mono.error(new RuntimeException("API Error")));

        // When & Then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    void getNewsByCategory_ShouldReturnIndexViewWithCategoryNews() throws Exception {
        // Given
        String category = "technology";
        NewsResponse newsResponse = createMockNewsResponse();
        when(newsService.getTopHeadlinesByCategory(category)).thenReturn(Mono.just(newsResponse));

        // When & Then
        mockMvc.perform(get("/category")
                .param("category", category))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("news", newsResponse))
                .andExpect(model().attribute("category", "Technology"));
    }

    @Test
    void getNewsByCategory_WhenServiceThrowsException_ShouldReturnIndexWithError() throws Exception {
        // Given
        String category = "technology";
        when(newsService.getTopHeadlinesByCategory(category))
                .thenReturn(Mono.error(new RuntimeException("API Error")));

        // When & Then
        mockMvc.perform(get("/category")
                .param("category", category))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("error"));
    }

    private NewsResponse createMockNewsResponse() {
        NewsResponse response = new NewsResponse();
        response.setStatus("ok");
        response.setTotalResults(1);

        NewsArticle article = new NewsArticle();
        article.setTitle("Test News Title");
        article.setDescription("Test news description");
        article.setUrl("https://example.com/news");
        article.setUrlToImage("https://example.com/image.jpg");
        article.setPublishedAt("2024-01-01T10:00:00Z");
        article.setAuthor("Test Author");

        Source source = new Source();
        source.setId("test-source");
        source.setName("Test Source");
        article.setSource(source);

        List<NewsArticle> articles = Arrays.asList(article);
        response.setArticles(articles);

        return response;
    }
}
