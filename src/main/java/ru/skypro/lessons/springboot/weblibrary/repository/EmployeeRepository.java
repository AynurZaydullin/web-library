package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.web.bind.annotation.PathVariable;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();

    public void addEmployee(Employee employee);
    public void editEmployee(Employee employee);
    public void deleteEmployee(Employee id);
}
