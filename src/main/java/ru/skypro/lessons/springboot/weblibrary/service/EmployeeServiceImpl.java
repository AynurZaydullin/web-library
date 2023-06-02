package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
//import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    public List<Employee> getAllEmployees() {
//        return employeeRepository.getAllEmployees();
//    }
//
//    public int getSumSalaryOfEmployees() {
//        return (int) employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).sum();
//    }
//    public OptionalInt getMinSalaryOfEmployees() {
//        return employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).min();
//    }
//    public OptionalInt getMaxSalaryOfEmployees() {
//        return employeeRepository.getAllEmployees().stream().map(Employee::getSalary).mapToInt(Integer::valueOf).max();
//    }
    public List<EmployeeDTO> getHighSalariesOfEmployees() {
        int averageSalary = (int) employeeRepository.getAllEmployees().stream().map(EmployeeDTO::getSalary).mapToInt(Integer::valueOf).average().getAsDouble();
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() > averageSalary).collect(Collectors.toList());
    }



    // Реализуем метод получения списка всех сотрудников
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        // Получаем список сотрудников из репозитория,
        // Преобразуем их в DTO и собираем в список
        return employeeRepository.findAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }


//    public List<Employee> getAllEmployees() {
//        List<Employee> result = new ArrayList<>();
//        employeeRepository.findAll()
//                .forEach(result::add);
//        return result;
//    }


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

//    @Override
//    public void addPosition(Position position) {
//        employeeRepository.save(position);
//    }
    // методы до переделки





//    @Override
//    public void addPosition(Position position) {
//        employeeRepository.save(position);
//    }


//
//    public void editEmployee(Employee employee) {
//        employeeRepository.editEmployee(employee);
//    }
//    public void deleteEmployee(long id) {
//        Employee employee = getEmployeeById(id);
//        employeeRepository.deleteEmployee(employee);
//    }
//    public Employee getEmployeeById(long id) {
//        List<Employee> employees = employeeRepository.getAllEmployees();
//        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
//    }
//    public List<Employee> getEmployeesWithSalaryHigherThan(int compareSalary) {
//        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() >  compareSalary).collect(Collectors.toList());
//    }
}
