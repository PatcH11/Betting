package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

    Picture findByName(String name);
}
