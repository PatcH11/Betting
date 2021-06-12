package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.example.betting.data.model.User;
import ru.example.betting.data.repository.UserRepository;
import ru.example.betting.security.CustomUserDetails;

/**
 * Реализация интерфейса UserDetailsService.
 *
 * @author Николай Евсюков
 */
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Репозиторий для пользователя.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Поиск сущности пользователя на основе его ника.
     *
     * @param username ник пользователя
     * @return основная информация о пользователе
     * @throws UsernameNotFoundException исключение, если пользователь не найден
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(user);
    }
}
