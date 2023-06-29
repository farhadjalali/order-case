package com.afkl.travel.exercise.config;

import com.afkl.travel.exercise.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfig {

    @Bean
    public Student getStudent(){
        return new Student();
    }

}
