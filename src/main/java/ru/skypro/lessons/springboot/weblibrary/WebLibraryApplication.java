package ru.skypro.lessons.springboot.weblibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("ru.skypro.lessons.springboot.weblibrary.*")
//@ComponentScan(basePackages = { "ru.skypro.lessons.springboot.weblibrary.*" })
//@EntityScan("ru.skypro.lessons.springboot.weblibrary.*")
@SpringBootApplication
public class WebLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLibraryApplication.class, args);
    }

}
