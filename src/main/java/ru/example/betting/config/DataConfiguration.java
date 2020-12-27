package ru.example.betting.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "ru.example.betting.data.model")
@EnableJpaRepositories(basePackages = "ru.example.betting.data.repository")
public class DataConfiguration {
}