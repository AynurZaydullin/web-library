package ru.skypro.lessons.springboot.weblibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebLibraryApplicationTests {
    private final WebLibraryApplication out = new WebLibraryApplication();
    @Test
    void contextLoads() {
    }
    @Test
    public void shouldReturnCorrectMessageWhenNameIsInUpperCase() {
        String result = out.getAllEmployees(UPPER_CASE_NAME);
        Assertions.assertTrue(result.contains(CORRECT_NAME));
        Assertions.assertArrayEquals(CORRECT_MESSAGE, result);
    }
}
