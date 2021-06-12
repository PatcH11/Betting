package ru.example.betting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс из которого происходит инициализация основного контекста приложения.
 *
 * @author Николай Евсюков
 */
@SpringBootApplication
public class App {

    /**
     * Точка входа в наш срвис.
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
