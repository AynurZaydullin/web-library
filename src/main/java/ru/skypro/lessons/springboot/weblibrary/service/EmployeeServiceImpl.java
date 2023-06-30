package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
//import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeePage;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeePage employeePage;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeePage employeePage) {
        this.employeeRepository = employeeRepository;
        this.employeePage = employeePage;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        // Получаем список сотрудников из репозитория,
        // Преобразуем их в DTO и собираем в список
        return employeeRepository.findAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getHighSalariesOfEmployees() {
        int averageSalary = (int) employeeRepository.getAllEmployees().stream().map(e -> e.getSalary()).mapToInt(Integer::valueOf).average().getAsDouble();
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() > averageSalary).map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
    }


    // Реализуем метод получения списка всех сотрудников

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAllEmployees().stream().map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
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
    public List<EmployeeFullInfo> findAllEmployeeById(long id) {
        return employeeRepository.findAllEmployeeById(id);
    }

    public List<EmployeeDTO> getEmployeesWithSalaryHigherThan(int compareSalary) {
        return employeeRepository.getAllEmployees().stream().filter(e -> e.getSalary() >  compareSalary).map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithPaging(int pageIndex, int unitPerPage) {
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        Page<Employee> page =  employeePage.findAll(employeeOfConcretePage);
        return page.stream().map(EmployeeDTO::fromEmployee)
                .toList();
    }
}
