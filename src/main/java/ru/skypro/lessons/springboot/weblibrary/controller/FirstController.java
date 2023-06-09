package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.service.CounterService;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;

// Создаем класс FirstController и делаем его контроллером
// с помощью аннотации @RestController
@RestController
@RequestMapping
public class FirstController {

    private final CounterService counterService;

    public FirstController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public String showHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/counter")
    public String showCounter(){
        return counterService.showCounter();
    }
}
