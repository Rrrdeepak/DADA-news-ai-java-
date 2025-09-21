package com.example.dailynewsapp.service;

import com.example.dailynewsapp.model.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NewsService {

    private final WebClient webClient;
    
    @Value("${news.api.key}")
    private String apiKey;
    
    @Value("${news.api.url}")
    private String apiUrl;

    public NewsService() {
        this.webClient = WebClient.builder().build();
    }

    public Mono<NewsResponse> getTopHeadlines() {
        String url = apiUrl + "?apiKey=" + apiKey + "&country=us&pageSize=20";
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(NewsResponse.class);
    }

    public Mono<NewsResponse> getTopHeadlinesByCategory(String category) {
        String url = apiUrl + "?apiKey=" + apiKey + "&country=us&category=" + category + "&pageSize=20";
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(NewsResponse.class);
    }
}
