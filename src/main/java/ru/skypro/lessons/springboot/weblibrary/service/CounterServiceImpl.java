package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;

@Service
class CounterServiceImpl implements CounterService {
    private int counter;

    public String showCounter(){
        return "Количество запросов " + ++counter;
    }
}
