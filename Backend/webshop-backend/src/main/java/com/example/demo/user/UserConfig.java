package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args ->{
                User user1 = new User("User1","Farkas Balázs","farkasbalazs0127@gmail.com","06308965170",hashPassword("habdubiblabla"),(byte)0,"","");
                User user2 = new User("User2","Horváth Istán","horvathistvan1206@gmail.com","06305436532",hashPassword("habdubiblabla"),(byte)0,"","");
                User user3 = new User("User3","Alexa Kornél","viagrahun@gmail.com","06303498672",hashPassword("habdubiblabla"),(byte)0,"","");
                repository.saveAll(List.of(user1,user2,user3));
        };
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedhash);
        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
