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

@Controller
public class AppController {

    private final IUserService userService;
    private final IPictureService pictureService;

    @Autowired
    public AppController(IUserService userService,
                         IPictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

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
