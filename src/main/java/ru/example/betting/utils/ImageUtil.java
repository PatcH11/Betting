package ru.example.betting.utils;

import java.util.Base64;

/**
 * Работа с картинкой.
 *
 * @author Николай Евсюков
 */
public class ImageUtil {

    /**
     * Преобразование картинки.
     *
     * @param byteData массив байт картинки
     * @return преобразованная строка
     */
    public String getImgData(byte[] byteData) {
        return Base64.getMimeEncoder().encodeToString(byteData);
    }
}
