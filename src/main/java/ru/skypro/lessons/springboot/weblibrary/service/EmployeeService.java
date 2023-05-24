package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    int getSumSalaryOfEmployees();
    OptionalInt getMinSalaryOfEmployees();
    OptionalInt getMaxSalaryOfEmployees();

    List<Employee> getHighSalariesOfEmployees();
    void addEmployee( Employee employee);

    void editEmployee(Employee employee);

    void deleteEmployee(long id);

    Employee getEmployeeById(long id);

    List<Employee>  getEmployeesWithSalaryHigherThan(int compareSalary);
}