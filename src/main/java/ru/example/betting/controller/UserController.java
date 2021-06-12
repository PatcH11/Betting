package ru.example.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.example.betting.data.model.User;
import ru.example.betting.services.service.IPictureService;
import ru.example.betting.services.service.IUserService;

import java.io.IOException;

/**
 * Контроллер для пользователя.
 *
 * @author Николай Евсюков
 */
@Controller
public class UserController {

    /**
     * Сервис для пользователя.
     */
    private final IUserService userService;

    /**
     * Сервис для картинки.
     */
    private final IPictureService pictureService;

    @Autowired
    public UserController(IUserService userService,
                          IPictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    /**
     * Отображение страницы signup_form.
     *
     * @param model модель
     * @return страницу
     */
    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("user", new User());

        return "index";
    }

    /**
     * Регистрация пользователя.
     *
     * @param file данные для сохраннения картини
     * @param user пользователь
     * @return странцу
     * @throws IOException исключение, при сохранении картинки
     */
    @PostMapping("/process_register")
    public String processRegister(@RequestParam("file") MultipartFile file,
                                  User user) throws IOException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        pictureService.create(file);

        user.setPicture(pictureService.findByName(StringUtils.cleanPath(file.getOriginalFilename())));
        userService.create(user);

        return "register_success";
    }
}
