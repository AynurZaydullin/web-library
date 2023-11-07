package ru.skypro.lessons.springboot.weblibrary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.service.*;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    //получение всех сотрудников

    @GetMapping("/all_employees")
    public List<EmployeeDTO> findAllEmployees() {
        try {
            return employeeService.findAllEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //получение имени и зарплаты сотрудников
    @GetMapping("/all_employees_view")
    public List<EmployeeView> findAllEmployeesView() {
        try {
            return employeeService.findAllEmployeesView();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //получение имени и зарплаты сотрудников в другой форме
    @GetMapping("/all_employees_info")
    public List<EmployeeInfo> findAllEmployeeInfo() {
        try {
            return employeeService.findAllEmployeeInfo();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //получение полной информации о сотрудниках: имя, зарплата, должность
    @GetMapping("/employee_full_info")
    public List<EmployeeFullInfo> findAllEmployeeFullInfo() {
        try {
            return employeeService.findAllEmployeeFullInfo();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
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
    public List<EmployeeDTO> getAllEmployees() {
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
    public List<EmployeeDTO> getHighSalariesOfEmployees() {
        try {
            return employeeService.getHighSalariesOfEmployees();
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //получение сотрудников с должностью, указанной в параметре "position"
    @GetMapping("/position")
    public List<EmployeeFullInfo> findAllEmployeeByPosition(@RequestParam("position") String position) {
        try {
            return employeeService.findAllEmployeeByPosition(position);
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/page")
    public List<EmployeeDTO> getEmployeeWithPaging(@RequestParam("page") Integer page) {
        try {
            return employeeService.getEmployeeWithPaging(page, 5);

        } catch (Throwable throwable) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //получение информации о сотруднике по переданному id
    @GetMapping("/fullInfo/{id}")
    public List<EmployeeFullInfo> findAllEmployeeById(@PathVariable long id) {
        try {
            return employeeService.findAllEmployeeById(id);
        } catch (Throwable t) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //Возвращение всех сотрудников, зарплата которых выше переданного параметра salary
    @GetMapping("/salary/salaryHigherThan")
    public List<EmployeeDTO> showEmployeesWithSalaryHigherThan(@RequestParam("compareSalary") int compareSalary) {
        try {
            return employeeService.getEmployeesWithSalaryHigherThan(compareSalary);
        } catch (Throwable t) {
            // В случае возникновения исключения выбрасываем
            // ResponseStatusException с указанием статуса 400 (Bad Request).
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //Получение списка сотрудников в JSON-формате и сохранение их в БД.
//    @PostMapping("/upload")
//    public List<EmployeeDTO> getEmployeesInJSON(@RequestBody )
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void upload(@RequestPart("employees") MultipartFile employees) {
//        employeeService.upload(employees);
//    }

}
