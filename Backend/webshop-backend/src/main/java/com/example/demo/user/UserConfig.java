package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args ->{
                User user1 = new User("User1","Farkas Balázs","farkasbalazs0127@gmail.com","06308965170","habdubiblabla",(byte)0,"","");
                User user2 = new User("User2","Horváth Istán","horvathistvan1206@gmail.com","06305436532","habdubiblabla",(byte)0,"","");
                User user3 = new User("User3","Alexa Kornél","viagrahun@gmail.com","06303498672","habdubiblabla",(byte)0,"","");
                repository.saveAll(List.of(user1,user2,user3));
        };
    }
}
