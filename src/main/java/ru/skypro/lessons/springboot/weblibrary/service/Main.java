package ru.skypro.lessons.springboot.weblibrary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTOSerializable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        // Задаем имя файла для сохранения
//        String fileName = "file.txt";

//        EmployeeDTO employeeDTO = new EmployeeDTO()
//                .setId(0l)
//                .setName("Aynur")
//                .setSalary(200_000);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(employeeDTO);
//        System.out.println(json);
//        String filePath = "employees.txt";
//        String content = readFromFile(filePath);
//        ObjectMapper objectMapper = new ObjectMapper();
//        EmployeeDTO employeeDTO = objectMapper.readValue("employees.txt", EmployeeDTO.class);
//        System.out.println(employeeDTO);
        // Создаем новый объект EmployeeDTO
//        EmployeeDTOSerializable employeeDTOSerializable = new EmployeeDTOSerializable();
//        employeeDTOSerializable.setName("Василий");
//        employeeDTOSerializable.setSalary(125000);
//
//        // Используем try-with-resources для автоматического закрытия потоков
//        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//             // Создаем поток для записи байтов в файл
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//            // Создаем поток для сериализации объекта
//
//            // Записываем сериализованный объект в файл
//            objectOutputStream.writeObject(employeeDTOSerializable);
//        }

//        EmployeeDTOSerializable employeeDTOSerializable = null;
//
//
//        try (FileInputStream fileInputStream = new FileInputStream(fileName);
//             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
//
//            employeeDTOSerializable = (EmployeeDTOSerializable) objectInputStream.readObject();
//        }
//
//        System.out.println(employeeDTOSerializable);
//        String filePath = "file.txt";
//        int age = 32;
//        String sunName = "Aynur";
//        System.out.println("Hello, " + sunName + ". " + "Your age are " + age + " years");
//        EmployeeDTO  employeeDTO = new EmployeeDTO()
//                .setName("Иван").s


//        String context = readFromFile("C:\\Users\\User\\IdeaProjects\\web-library\\src\\main\\java\\ru\\skypro\\lessons\\springboot\\weblibrary\\service\\file.txt");
//        System.out.println(context);
        //        String context = readFromFile("C:\\Users\\User\\IdeaProjects\\web-library\\src\\main\\java\\ru\\skypro\\lessons\\springboot\\weblibrary\\service\\file.txt");
//        System.out.println(context);
//        String content = "Denis";
//        writToFile(filePath, content);
//
//        content = readFromFile(filePath);
//        System.out.println(content);


//        String fileName = "file.txt";
//        // listing про ФАйлы
//        File file = new File(filePath);
//        Path path = file.toPath();
//        path = Paths.get(filePath);
//        //второй
//        String content = " dfdfs";
//        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
//
//        // конец второй
//        System.out.println(Files.exists(path));
//        System.out.println(Files.size(path));
//
//        // Выводим абсолютный путь к файлу
//        System.out.println("Абсолютный путь " + file.getAbsolutePath());
//
//        // Проверяем, существует ли файл, и выводим результат
//        System.out.println("Файл существует ? " + file.exists());
//        // Выводим размер файла в байтах
//        System.out.println("Размер файла " + file.length() + " байт");
//
//        System.out.println(file.delete());
//        System.out.println(file.delete());
//        System.out.println(file.createNewFile());
//        System.out.println(file.length());
//        System.out.println(file.createNewFile());
//        File newFile = new File("null.txt");
//        System.out.println(file.renameTo(newFile));

//        File file = new File(fileName);
//
//        // Выводим абсолютный путь к файлу
//        System.out.println("Абсолютный путь " + file.getAbsolutePath());
//
//        // Проверяем, существует ли файл, и выводим результат
//        System.out.println("Файл существует ? " + file.exists());
//
//        // Проверяем, является ли файл папкой, и выводим результат
//        System.out.println("Это папка ? " + file.isDirectory());
//
//        // Проверяем, является ли файл файлом, и выводим результат
//        System.out.println("Это файл ? " + file.isFile());
//
//        // Выводим размер файла в байтах
//        System.out.println("Размер файла " + file.length() + " байт");

        //Listing 2.
//        String fileName = "file.txt";
//        String text = "Я могу прочитать и вывести текст из этого файла.";
//
//        // Вызываем метод writeTextToFile для записи текста в файл
//        writeTextToFile(text, fileName);
//
//        // Вызываем метод readTextFromFile для чтения текста из файла
//        String content = readTextFromFile(fileName);
//        System.out.println(content);
    }

//    private static String readFromFile(String filePath) {
//        try(InputStream inputStream = new FileInputStream(filePath)) {
//
//            int fileSize = inputStream.available();
//            byte[] byteArray = new byte[fileSize];
//            inputStream.read(byteArray);
//            return new String(byteArray, StandardCharsets.UTF_8);
////            StringBuilder stringBuilder = new StringBuilder();
////            int byteContent;
////            while ((byteContent = inputStream.read()) != -1) {
////                char c = (char) byteContent;
////                stringBuilder.append(c);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
////        return "filePath";
//    }
//
//    private static void writToFile(String filePath, String content) {
//        try (OutputStream outputStream = new FileOutputStream(filePath)) {
//            outputStream.write(content.getBytes());
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //listing 3
    // Создаем метод writeTextToFile для записи текста в файл
    // с использованием класса Files
//    private static void writeTextToFile(String text, String fileName) {
//        Path path = Paths.get(fileName);
//        try {
//            // Записываем текст в файл с кодировкой UTF-8
//            Files.write(path, text.getBytes(StandardCharsets.UTF_8));
//        } catch (IOException ioException) {
//            // В случае ошибки выводим стек вызовов
//            ioException.printStackTrace();
//        }
//    }

    // Создаем метод readTextFromFile для чтения текста из файла
    // с использованием класса Files
//    private static String readTextFromFile(String fileName) {
//        Path path = Paths.get(fileName);
//        try {
//            // Читаем текст из файла и объединяем все строки в одну строку
//            return Files.lines(path)
//                    .collect(Collectors.joining());
//        } catch (IOException ioException) {
//            // В случае ошибки выводим стек вызовов и возвращаем пустую строку
//            ioException.printStackTrace();
//            return "";
//        }
//    }
}

//listing 4 Сериализация
//public class EmployeeDTO implements Serializable {
//    private String name;
//    private Integer salary;
//
//    // Создаем метод для получения имени сотрудника
//    public String getName() {
//        return name;
//    }
//
//    // Создаем метод для установки имени сотрудника
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    // Создаем метод для получения зарплаты сотрудника
//    public int getSalary() {
//        return salary;
//    }
//
//    // Создаем метод для установки зарплаты сотрудника
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    // Создаем метод для представления информации о сотруднике в виде строки
//    @Override
//    public String toString() {
//        return "EmployeeDTO{" +
//                "name='" + name + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//}
