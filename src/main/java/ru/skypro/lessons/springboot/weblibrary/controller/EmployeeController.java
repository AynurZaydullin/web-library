package ru.skypro.lessons.springboot.weblibrary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    //Получение списка сотрудников
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        try {
            return employeeService.getAllEmployees();
        } catch (Throwable t) {
            // В случае возникновения исключения выбрасываем
            // ResponseStatusException с указанием статуса 400 (Bad Request).
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //Получение суммы зарплат сотрудников
    @GetMapping("/salary/sum")
    public int getSumSalaryOfEmployees() {
        try {
            return employeeService.getSumSalaryOfEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Получение сотрудника с минимальной зарплатой
    @GetMapping("/salary/min")
    public OptionalInt getMinSalaryOfEmployees() {
        try {
            return employeeService.getMinSalaryOfEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Получение сотрудника с максимальной зарплатой
    @GetMapping("/salary/max")
    public OptionalInt getMaxSalaryOfEmployees() {
        try {
            return employeeService.getMaxSalaryOfEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Получение всех сотрудников, зарплата которых больше средней
    @GetMapping("/salary/high-salary")
    public List<Employee> getHighSalariesOfEmployees() {
        try {
            return employeeService.getHighSalariesOfEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Создание множества новых сотрудников
    @PostMapping("/")
    public void addEmployee(@RequestBody  Employee employee) {
        try {
            employeeService.addEmployee(employee);
            System.out.println(employee.toString());
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Редактирование сотрудника с указанным id
    @PutMapping("/edit")
    public void editEmployees(@RequestBody  Employee employee) {
        try {
            employeeService.editEmployee(employee);
            System.out.println(employee.toString());
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Возвращение информации о сотруднике с переданным id

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        try {
             return employeeService.getEmployeeById(id);
        } catch (Throwable t) {
            // В случае возникновения исключения выбрасываем
            // ResponseStatusException с указанием статуса 400 (Bad Request).
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Возвращение всех сотрудников, зарплата которых выше переданного параметра salary
    @GetMapping("/salary/higher")
    public List<Employee> showEmployeesWithSalaryHigherThan(@RequestParam("compareSalary") int  compareSalary) {
        try {
            return employeeService.getEmployeesWithSalaryHigherThan(compareSalary);
        } catch (Throwable t) {
            // В случае возникновения исключения выбрасываем
            // ResponseStatusException с указанием статуса 400 (Bad Request).
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    //Удаление сотрудника с переданным id
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        try {
            employeeService.deleteEmployee(id);
        }catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
