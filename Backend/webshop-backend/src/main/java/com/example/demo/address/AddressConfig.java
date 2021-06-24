package com.example.demo.address;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AddressConfig {
    @Bean(name = "addressbean")
    CommandLineRunner commandLineRunner(AddressRepository repository){
        return args ->{
           Address a1 = new Address(1,"Hugnary","Felsőtárkány","Virág","9");
           repository.save(a1);
        };
    }
}
