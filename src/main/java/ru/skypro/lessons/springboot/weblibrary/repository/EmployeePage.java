package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lessons.springboot.weblibrary.service.pojo.Employee;

public interface EmployeePage extends PagingAndSortingRepository<Employee, Integer> {
}
