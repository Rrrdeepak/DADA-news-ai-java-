package com.example.dailynewsapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "news.api.key=test-key",
    "news.api.url=https://test-api.com"
})
class DailyNewsAppApplicationTest {

    @Test
    void contextLoads() {
        // This test ensures that the Spring application context loads successfully
        // If there are any configuration issues, this test will fail
    }
}
