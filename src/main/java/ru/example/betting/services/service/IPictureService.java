package ru.example.betting.services.service;

import org.springframework.web.multipart.MultipartFile;
import ru.example.betting.data.model.Picture;

import java.io.IOException;

/**
 * Интерфейс для сервиса картинки.
 *
 * @author Николай Евсюков
 */
public interface IPictureService {

    /**
     * Создать картинку.
     *
     * @param picture данные для создания картинки в базе данных
     * @return созданная картинка
     * @throws IOException исключение при создании картинки
     */
    Picture create(MultipartFile picture) throws IOException;

    /**
     * Вернуть картинку по ее ID.
     *
     * @param id ID картинки
     * @return найденная картинка
     */
    Picture getPicture(int id);

    /**
     * Вернуть картинку по ее названию.
     *
     * @param name название картинки
     * @return найденная картинка
     */
    Picture findByName(String name);
}
