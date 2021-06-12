package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Picture;

/**
 * Репозиторий для картинок.
 *
 * @author Николай Евсюков
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

    /**
     * Поиск картинки по ее названию.
     *
     * @param name название картинки
     * @return найденная картинка
     */
    Picture findByName(String name);
}
