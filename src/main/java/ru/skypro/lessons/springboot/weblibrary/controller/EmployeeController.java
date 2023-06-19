package ru.skypro.lessons.springboot.weblibrary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.service.*;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    //получение всех сотрудников

    @GetMapping("/all_employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    //получение имени и зарплаты сотрудников
    @GetMapping("/all_employees_view")
    public List<EmployeeView> findAllEmployeesView() {
        return employeeService.findAllEmployeesView();
    }

    //получение имени и зарплаты сотрудников в другой форме
    @GetMapping("/all_employees_info")
    public List<EmployeeInfo> findAllEmployeeInfo() {
        return employeeService.findAllEmployeeInfo();
    }

    //получение полной информации о сотрудниках: имя, зарплата, должность
    @GetMapping("/employee_full_info")
    public List<EmployeeFullInfo> findAllEmployeeFullInfo() {
        return employeeService.findAllEmployeeFullInfo();
    }

    //добавление нового сотрудника
    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee) {
        try {
            employeeService.addEmployee(employee);
            System.out.println(employee.toString());
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    //получение всех сотрудников
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

    //получение сотрудников с зарплатой выше средней
    @GetMapping("/salary/high-salary")
    public List<Employee> getHighSalariesOfEmployees() {
        try {
            return employeeService.getHighSalariesOfEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //этот метод получился
    //получение сотрудников с должностью, указанной в параметре "position"
    @GetMapping("/position")
    public List<EmployeeFullInfo> findAllEmployeeByPosition(@RequestParam("position") String  position) {
        try {
                return employeeService.findAllEmployeeByPosition(position);
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //этот метод не получился
    //получение информации о сотруднике по переданному id
    @GetMapping("/{id}/fullInfo")
    public List<EmployeeFullInfo> findAllEmployeeById(@PathVariable(required = false) long  id) {
        try {
            return employeeService.findAllEmployeeById(id);
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //этот метод получился
    //Возвращение всех сотрудников, зарплата которых выше переданного параметра salary
    @GetMapping("/salary/salaryHigherThan")
    public List<Employee> showEmployeesWithSalaryHigherThan(@RequestParam("compareSalary") int  compareSalary) {
        try {
            return employeeService.getEmployeesWithSalaryHigherThan(compareSalary);
        } catch (Throwable t) {
            // В случае возникновения исключения выбрасываем
            // ResponseStatusException с указанием статуса 400 (Bad Request).
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //этот метод не получился:
    // ошибка исходит из класса EmployeeServiceImpl;
    // непонятно почему компилятор ругается на строчку, показанную ниже: он
    // пишет, что должно быть "0" аргументов вместо "1" аргумента.
    //возвращение информации о сотрудниках, основываясь на номере страницы
    @GetMapping("/page")
    public List<Employee> getEmployeeWithPaging(@RequestParam("page") int  page, int numberOfString) {
        try {
            return employeeService.getEmployeeWithPaging(page, numberOfString);
        } catch (Throwable t) {
            // В случае возникновения исключения выбрасываем
            // ResponseStatusException с указанием статуса 400 (Bad Request).
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
