package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
//import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public List<Employee> getHighSalariesOfEmployees() {
        int averageSalary = (int) employeeRepository.getAllEmployees().stream().map(e -> e.getSalary()).mapToInt(Integer::valueOf).average().getAsDouble();
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() > averageSalary).collect(Collectors.toList());
    }


    // Реализуем метод получения списка всех сотрудников

    //методы до переделки
    @Override
    public void addEmployee(Employee employee) {
//        employeeRepository.addEmployee(employee);
        employeeRepository.save(employee);
    }
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Override
    public List<EmployeeView> findAllEmployeesView() {
        return employeeRepository.findAllEmployeeView();
    }

    @Override
    public List<EmployeeInfo> findAllEmployeeInfo() {
        return employeeRepository.findAllEmployeeInfo();
    }

    @Override
    public List<EmployeeFullInfo> findAllEmployeeFullInfo() {
        return employeeRepository.findAllEmployeeFullInfo();
    }

    @Override
    public List<EmployeeFullInfo> findAllEmployeeByPosition(String position) {
            return employeeRepository.findAllEmployeeFullInfo().stream().filter(e -> e.getPositionName().equals(position)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeFullInfo> findAllEmployeeById(String position) {
        return employeeRepository.findAllEmployeeFullInfo().stream().filter(e -> e.).collect(Collectors.toList());
    }

    // методы до переделки


    public List<Employee> getEmployeesWithSalaryHigherThan(int compareSalary) {
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() >  compareSalary).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage) {
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        //непонятно почему компилятор ругается на строчку, показанную ниже: он
        //пишет, что должно быть "0" аргументов вместо "1" аргумента.
        Page<Employee> page = employeeRepository.findAll(employeeOfConcretePage);

        return page.stream()
                .toList();
    }
}
