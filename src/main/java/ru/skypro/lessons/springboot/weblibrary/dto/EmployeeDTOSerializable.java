package ru.skypro.lessons.springboot.weblibrary.dto;

import java.io.Serializable;

public class EmployeeDTOSerializable  implements Serializable {
    private String name;
    private Integer salary;

    // Создаем метод для получения имени сотрудника
    public String getName() {
        return name;
    }

    // Создаем метод для установки имени сотрудника
    public void setName(String name) {
        this.name = name;
    }

    // Создаем метод для получения зарплаты сотрудника
    public int getSalary() {
        return salary;
    }

    // Создаем метод для установки зарплаты сотрудника
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Создаем метод для представления информации о сотруднике в виде строки
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}