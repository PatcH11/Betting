package ru.example.betting.utils;

/**
 * Генерация случайных чисел.
 *
 * @author Николай Евсюков
 */
public class GeneratingNumbers {

    /**
     * Генерация случайных числе в промежутке от 0 до max.
     *
     * @param max максимальное число
     * @return случайное число в промежутке от 0 до max
     */
    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }
}
