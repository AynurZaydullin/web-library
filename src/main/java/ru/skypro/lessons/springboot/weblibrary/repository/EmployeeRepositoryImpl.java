package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // Коллекция для имитации данных
    public  List<Employee> employeeList = new ArrayList<>(
            List.of(
            new Employee(1,"Катя", 90_000),
            new Employee(2,"Дима", 102_000),
            new Employee(3,"Олег", 80_000),
            new Employee(4,"Вика", 165_000))
    );

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println(employeeList);
    }

    @Override
    public void editEmployee(Employee employee) {
        long id =  employee.getId();
        String name = employee.getName();
        int salary = employee.getSalary();
        employee =  employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        employee.setName(name);
        employee.setSalary(salary);
        System.out.println(employeeList);
    }
    @Override
    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
        System.out.println(employeeList);
    }
}