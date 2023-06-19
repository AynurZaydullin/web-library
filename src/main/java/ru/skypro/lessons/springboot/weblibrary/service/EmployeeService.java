package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface EmployeeService {

    List<Employee> getHighSalariesOfEmployees();



    // Реализуем метод получения списка всех сотрудников

    List<Employee> getAllEmployees();

    //методы до корректировки
    void addEmployee( Employee employee);
    List<Employee> findAllEmployees();

    List<EmployeeView> findAllEmployeesView();

    List<EmployeeInfo> findAllEmployeeInfo();

    List<EmployeeFullInfo> findAllEmployeeFullInfo();

    List<EmployeeFullInfo> findAllEmployeeByPosition(String  position);
    List<EmployeeFullInfo> findAllEmployeeById(long  id);

    List<Employee>  getEmployeesWithSalaryHigherThan(int compareSalary);
    List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage);
}