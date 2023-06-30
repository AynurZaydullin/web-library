package ru.skypro.lessons.springboot.weblibrary.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeFullInfo {
    // Имя сотрудника
    private String name;
    // Зарплата сотрудника
    private Integer salary;
    // Название должности сотрудника
    private String positionName;
}
