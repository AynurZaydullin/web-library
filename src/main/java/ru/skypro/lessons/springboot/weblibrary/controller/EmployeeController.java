package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

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
}
