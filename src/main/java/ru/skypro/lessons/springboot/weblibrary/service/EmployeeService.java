package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    int getSumSalaryOfEmployees();
    OptionalInt getMinSalaryOfEmployees();
    OptionalInt getMaxSalaryOfEmployees();

    List<Employee> getHighSalariesOfEmployees();
}