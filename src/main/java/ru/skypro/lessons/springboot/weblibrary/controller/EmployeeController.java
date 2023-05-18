package ru.skypro.lessons.springboot.weblibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public int showSumSalaryOfEmployees() {
        return employeeService.getSumSalaryOfEmployees();
    }
    @GetMapping("/salary/min")
    public OptionalInt showMinSalaryOfEmployees() {
        return employeeService.getMinSalaryOfEmployees();
    }
    @GetMapping("/salary/max")
    public OptionalInt showMaxSalaryOfEmployees() {
        return employeeService.getMaxSalaryOfEmployees();
    }
    @GetMapping("/salary/high-salary")
    public List<Employee> showHighSalariesOfEmployees() {
        return employeeService.getHighSalariesOfEmployees();
    }
    // Создаем эндпоинт для подсчета сотрудников в указанном отделе
    @GetMapping("/count/{division}")
    public int getDivisionEmployeesCount(@PathVariable String division) {
        // ...
        return 0;
    }
}
