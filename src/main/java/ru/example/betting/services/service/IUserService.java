package ru.example.betting.services.service;

import ru.example.betting.data.model.User;

/**
 * Интерфейс для сервиса пользователя.
 *
 * @author Николай Евсюков
 */
public interface IUserService {

    /**
     * Создание пользователя.
     *
     * @param user пользователь
     * @return созданный пользователь
     */
    User create(User user);

    /**
     * Поиск пользователя по его нику.
     *
     * @param username ник пользователя
     * @return найденный пользователь
     */
    User findByUsername(String username);
}
