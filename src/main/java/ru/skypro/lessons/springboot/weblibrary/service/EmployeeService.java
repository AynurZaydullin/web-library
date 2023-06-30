package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getHighSalariesOfEmployees();



    // Реализуем метод получения списка всех сотрудников

//    List<Employee> getAllEmployees();
    List<EmployeeDTO> getAllEmployees();

    //методы до корректировки
    void addEmployee( Employee employee);
    List<EmployeeDTO> findAllEmployees();

    List<EmployeeView> findAllEmployeesView();

    List<EmployeeInfo> findAllEmployeeInfo();

    List<EmployeeFullInfo> findAllEmployeeFullInfo();

    List<EmployeeFullInfo> findAllEmployeeByPosition(String  position);
    List<EmployeeFullInfo> findAllEmployeeById(long  id);

    List<EmployeeDTO> getEmployeesWithSalaryHigherThan(int compareSalary);

    List<EmployeeDTO> getEmployeeWithPaging(int pageIndex, int unitPerPage);
//    List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage);
}