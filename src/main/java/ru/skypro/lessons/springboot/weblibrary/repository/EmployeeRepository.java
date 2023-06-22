package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeInfo;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeView;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    //начало листинга из вэб-бинера
//    List<EmployeeDTO> getAllEmployees();
//
//    //начало почти сделанной домашки
    List<Employee> findAll();
    @Query(value = "SELECT * FROM employee",
            nativeQuery = true)
    List<Employee> findAllEmployees();
    @Query(value = "SELECT * FROM employee",
            nativeQuery = true)
    List<EmployeeView> findAllEmployeeView();
    @Query(value = "SELECT * FROM employee",
            nativeQuery = true)
    List<EmployeeInfo> findAllEmployeeInfo();
    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.service." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p")
    List<EmployeeFullInfo> findAllEmployeeFullInfo();


//    @Query(value = "SELECT * FROM employee WHERE name= :name",
//            nativeQuery = true)
//    List<Employee> findAllEmployeeByPosition(@Param("name") String  position);
    @Query(value = "SELECT * FROM employee",
            nativeQuery = true)
    List<Employee> getAllEmployees();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.service." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND e.id = ?1")
    List<EmployeeFullInfo> findAllEmployeeById(long  id);
//конец почти сделанной домашки
}
