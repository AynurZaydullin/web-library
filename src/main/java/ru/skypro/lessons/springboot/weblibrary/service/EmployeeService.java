package ru.skypro.lessons.springboot.weblibrary.service;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.exeptions.IllegalJsonFileException;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.io.IOException;
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
//    void upload(MultipartFile employees);
//    {
//        try {
//            String extension = StringUtils.getFilenameExtension(employees.getOriginalFilename());
//            if (!"json".equals(extension)){
//                throw new IllegalJsonFileException();
//            }
//            List<EmployeeDTO> employeeDTOS = objectMapper.readValue(
//                    employees.getBytes(),
//                    new TypeReference<>() {
//
//                    }
//            );
//        } catch (IOException e) {
//            throw new IllegalJsonFileException();
//        }
//    }
//    public int createReport(){
//        try {
//            Report report = new Report();
//            report.setReport(buildReport());
//            return reportRepository.save(report).getId();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new HttpServerErrorException.InternalServerError();
//        }
//    }
//    public String buildReport() throws JsonProcessingException {
//        List<ReportDTO> reports = EmployeeRepository.buildReports();
//        return objectMapper.writeValueAsString(reports);
//    }
//
//    public Resource downloadReport(int id){
//        return new ByteArrayInputResource(
//                reportRepository.findById(id)
//                        .orElseThrow(ReportNotFoundExeption::new)
//                        .getReport()
//                        .getBytes(StandardCharsets.UTF_8)
//        );
//    }
}