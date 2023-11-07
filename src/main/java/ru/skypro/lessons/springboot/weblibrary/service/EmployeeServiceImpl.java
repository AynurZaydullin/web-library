package ru.skypro.lessons.springboot.weblibrary.service;

import aj.org.objectweb.asm.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
//import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.exeptions.IllegalJsonFileException;
import ru.skypro.lessons.springboot.weblibrary.exeptions.InternalServerError;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeePage;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeePage employeePage;
//    private final ObjectMapper objectMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeePage employeePage){//, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.employeePage = employeePage;
//        this.objectMapper = objectMapper;
    }

//    public void createBatchEmployees(List<EmployeeDTO> employees) {
//        employees.stream()
//                .map(employeeMapper::toEntity)
//                .forEach(employeeRepository::save);
//    }

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
        try{
            employeeRepository.save(employee);
        } catch (Exception  e){
            throw new InternalServerError();
        }

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

//    @Override
//    public void upload(MultipartFile employees) {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            String extension = StringUtils.getFilenameExtension(employees.getOriginalFilename());
//            if (!"json".equals(extension)) {
//                throw new IllegalJsonFileException();
//            }
//            List<EmployeeDTO> employeeDTOS = objectMapper.readValue(
//                    employees.getBytes(),
//                    new TypeReference<>() {
//
//                    }
//            );
////            createBatchEmployees(employeeDTOS);
//        }catch (IOException e) {
//            throw new IllegalJsonFileException();
//        }
//    }
}
