package ru.example.betting.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.example.betting.data.model.User;

import java.util.Collection;

/**
 * Реализация интерфейса UserDetails.
 *
 * @author Николай Евсюков
 */
public class CustomUserDetails implements UserDetails {

    /**
     * Наш кастомный пользователь.
     */
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * Возвращает полномочия, предоставленные пользователю.
     *
     * @return коллекцию полномочий
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Возвращение пороля для нашего пользователя.
     *
     * @return пароль пользователя
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Возвращение ника для нашего пользователя.
     *
     * @return ник пользователя
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Указывает, истек ли срок действия учетной записи пользователя.
     *
     * @return статус пользователя
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Указывает, заблокирован пользователь или разблокирован.
     *
     * @return статус пользователя
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Указывает, истек ли срок действия учетных данных (пароля) пользователя.
     *
     * @return статус пользователя
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Указывает, включен или отключен пользователь.
     *
     * @return статус пользователя
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Возвращение полного имени пользователя.
     *
     * @return полное имя пользователя
     */
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }
}
