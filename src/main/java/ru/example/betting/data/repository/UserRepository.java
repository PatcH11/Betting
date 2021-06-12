package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.User;

/**
 * Репозиторий для пользователя.
 *
 * @author Николай Евсюков
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Поиск пользователя по его нику.
     *
     * @param username ник пользователя
     * @return найденный пользователь
     */
    User findByUsername(String username);
}
