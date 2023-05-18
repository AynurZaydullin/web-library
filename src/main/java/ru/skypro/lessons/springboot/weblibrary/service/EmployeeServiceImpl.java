package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public int getSumSalaryOfEmployees() {
        return (int) employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).sum();
    }
    public OptionalInt getMinSalaryOfEmployees() {
        return employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).min();
    }
    public OptionalInt getMaxSalaryOfEmployees() {
        return employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).max();
    }
    public List<Employee> getHighSalariesOfEmployees() {
        int averageSalary = (int) employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).average().getAsDouble();
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() > averageSalary).collect(Collectors.toList());
    }
}
