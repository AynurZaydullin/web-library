//package ru.skypro.lessons.springboot.weblibrary.repository;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.PathVariable;
//import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@Repository
//public class EmployeeRepositoryImpl implements EmployeeRepository {
//
//    // Коллекция для имитации данных
//    public  List<Employee> employeeList = new ArrayList<>(
//            List.of(
//            new Employee(1,"Катя", 90_000),
//            new Employee(2,"Дима", 102_000),
//            new Employee(3,"Олег", 80_000),
//            new Employee(4,"Вика", 165_000))
//    );
//
////    @Override
////    public List<Employee> getAllEmployees() {
////        return employeeList;
////    }
//
//    @Override
//    public void addEmployee(Employee employee) {
//        EmployeeRepository.save(employee);
//    }
//
////    @Override
////    public void editEmployee(Employee employee) {
////        long id =  employee.getId();
////        String name = employee.getName();
////        int salary = employee.getSalary();
////        employee =  employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
////        employee.setName(name);
////        employee.setSalary(salary);
////        System.out.println(employeeList);
////    }
////    @Override
////    public void deleteEmployee(Employee employee) {
////        employeeList.remove(employee);
////        System.out.println(employeeList);
////    }
//
////    @Override
////    public <S extends Employee> S save(S entity) {
////        return null;
////    }
////
////    @Override
////    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
////        return null;
////    }
////
////    @Override
////    public Optional<Employee> findById(Integer integer) {
////        return Optional.empty();
////    }
////
////    @Override
////    public boolean existsById(Integer integer) {
////        return false;
////    }
////
////    @Override
////    public Iterable<Employee> findAll() {
////        return null;
////    }
////
////    @Override
////    public Iterable<Employee> findAllById(Iterable<Integer> integers) {
////        return null;
////    }
////
////    @Override
////    public long count() {
////        return 0;
////    }
////
////    @Override
////    public void deleteById(Integer integer) {
////
////    }
////
////    @Override
////    public void delete(Employee entity) {
////
////    }
////
////    @Override
////    public void deleteAllById(Iterable<? extends Integer> integers) {
////
////    }
////
////    @Override
////    public void deleteAll(Iterable<? extends Employee> entities) {
////
////    }
////
////    @Override
////    public void deleteAll() {
////
////    }
////
////    @Override
////    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
////        return null;
////    }
////
////    @Override
////    public Optional<Employee> findById(Integer integer) {
////        return Optional.empty();
////    }
////
////    @Override
////    public boolean existsById(Integer integer) {
////        return false;
////    }
////
////    @Override
////    public Iterable<Employee> findAll() {
////        return null;
////    }
////
////    @Override
////    public Iterable<Employee> findAllById(Iterable<Integer> integers) {
////        return null;
////    }
////
////    @Override
////    public long count() {
////        return 0;
////    }
////
////    @Override
////    public void deleteById(Integer integer) {
////
////    }
////
////    @Override
////    public void delete(Employee entity) {
////
////    }
////
////    @Override
////    public void deleteAllById(Iterable<? extends Integer> integers) {
////
////    }
////
////    @Override
////    public void deleteAll(Iterable<? extends Employee> entities) {
////
////    }
////
////    @Override
////    public void deleteAll() {
////
////    }
//}