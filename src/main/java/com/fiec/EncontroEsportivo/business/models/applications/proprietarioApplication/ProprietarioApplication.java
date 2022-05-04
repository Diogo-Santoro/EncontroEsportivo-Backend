package com.fiec.EncontroEsportivo.business.models.applications.proprietarioApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProprietarioApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProprietarioApplication.class, args);

    }


    @Bean
    public WebMvcConfigurer corsProprietarioConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}