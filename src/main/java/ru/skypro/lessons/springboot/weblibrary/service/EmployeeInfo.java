package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeInfo {

    @Value("#{target.name + ' ' + target.salary}")
    String getFullInfo();
}
