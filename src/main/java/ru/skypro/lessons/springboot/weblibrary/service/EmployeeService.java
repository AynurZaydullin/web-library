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
//    List<Employee> getAllEmployees();
//
//    int getSumSalaryOfEmployees();
//    OptionalInt getMinSalaryOfEmployees();
//    OptionalInt getMaxSalaryOfEmployees();
//
    List<EmployeeDTO> getHighSalariesOfEmployees();





    // Реализуем метод получения списка всех сотрудников

//    List<Employee> getAllEmployees();

    //методы до корректировки
    void addEmployee( Employee employee);
    List<EmployeeDTO> getAllEmployees();
    List<Employee> findAllEmployees();

    List<EmployeeView> findAllEmployeesView();

    List<EmployeeInfo> findAllEmployeeInfo();

    List<EmployeeFullInfo> findAllEmployeeFullInfo();

//    void addPosition(Position position);
    //методы до корректировки





//    void addPosition(Position position);

//    void editEmployee(Employee employee);
//
//    void deleteEmployee(long id);
//
//    Employee getEmployeeById(long id);
//
//    List<Employee>  getEmployeesWithSalaryHigherThan(int compareSalary);
}