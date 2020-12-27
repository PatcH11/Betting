package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.example.betting.data.model.Picture;
import ru.example.betting.data.repository.PictureRepository;
import ru.example.betting.services.service.IPictureService;

import java.io.IOException;

@Service
public class PictureServiceImpl implements IPictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture create(MultipartFile picture) throws IOException {
        String name = StringUtils.cleanPath(picture.getOriginalFilename());
        Picture pic = new Picture(name, picture.getContentType(), picture.getBytes());

        return pictureRepository.save(pic);
    }

    @Override
    public Picture getPicture(int id) {
        return pictureRepository.findById(id).get();
    }

    @Override
    public Picture findByName(String name) {
        return pictureRepository.findByName(name);
    }
}
