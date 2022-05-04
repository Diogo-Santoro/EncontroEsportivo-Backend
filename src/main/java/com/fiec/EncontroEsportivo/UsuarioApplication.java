package com.fiec.EncontroEsportivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
public class UsuarioApplication {

    public static void main(String[] args) {

        SpringApplication.run(UsuarioApplication.class, args);
        try {
            Files.createDirectory(Paths.get("uploads"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public WebMvcConfigurer corsUsuarioConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}