package ru.example.betting.services.service;

import org.springframework.web.multipart.MultipartFile;
import ru.example.betting.data.model.Picture;

import java.io.IOException;

public interface IPictureService {

    Picture create(MultipartFile picture) throws IOException;

    Picture getPicture(int id);

    Picture findByName(String name);
}
