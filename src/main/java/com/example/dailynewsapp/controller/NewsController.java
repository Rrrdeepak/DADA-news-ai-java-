package com.example.dailynewsapp.controller;

import com.example.dailynewsapp.model.NewsResponse;
import com.example.dailynewsapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String home(Model model) {
        try {
            NewsResponse newsResponse = newsService.getTopHeadlines().block();
            model.addAttribute("news", newsResponse);
            model.addAttribute("category", "All News");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch news. Please try again later.");
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/category")
    public String getNewsByCategory(@RequestParam String category, Model model) {
        try {
            NewsResponse newsResponse = newsService.getTopHeadlinesByCategory(category).block();
            model.addAttribute("news", newsResponse);
            model.addAttribute("category", category.substring(0, 1).toUpperCase() + category.substring(1));
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch news for category: " + category);
            e.printStackTrace();
        }
        return "index";
    }
}
