package com.example.dailynewsapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceTest {

    private Source source;

    @BeforeEach
    void setUp() {
        source = new Source();
    }

    @Test
    void testGettersAndSetters() {
        // Given
        String id = "test-source-id";
        String name = "Test Source Name";

        // When
        source.setId(id);
        source.setName(name);

        // Then
        assertEquals(id, source.getId());
        assertEquals(name, source.getName());
    }

    @Test
    void testDefaultConstructor() {
        // When
        Source newSource = new Source();

        // Then
        assertNotNull(newSource);
        assertNull(newSource.getId());
        assertNull(newSource.getName());
    }
}
