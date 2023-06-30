package ru.skypro.lessons.springboot.weblibrary.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {

    // Идентификатор должности, генерируется автоматически
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Название должности
    private String name;

    // Геттеры, сеттеры, конструкторы
}
