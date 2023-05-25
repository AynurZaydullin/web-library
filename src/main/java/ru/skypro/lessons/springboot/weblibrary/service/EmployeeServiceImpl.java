package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.Optional;
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

    public void addEmployee(Employee newEmployee) {
        employeeRepository.addEmployee(newEmployee);
    }

    public void editEmployee(Employee newEmployee) {
        employeeRepository.editEmployee(newEmployee);
    }
    public void deleteEmployee(long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.deleteEmployee(employee);
    }
    public Employee getEmployeeById(long id) {
        List<Employee> employees = employeeRepository.getAllEmployees();
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    public List<Employee> getEmployeesWithSalaryHigherThan(int compareSalary) {
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() >  compareSalary).collect(Collectors.toList());
    }
}
