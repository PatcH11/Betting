package ru.example.betting.services.service;

import ru.example.betting.data.model.User;

public interface IUserService {

    User create(User user);

    User findByUsername(String username);
}
