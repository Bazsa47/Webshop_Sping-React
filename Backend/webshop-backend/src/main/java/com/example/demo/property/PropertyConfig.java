package com.example.demo.property;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PropertyConfig {
    @Bean(name = "propertybean")
    CommandLineRunner commandLineRunner(PropertyRepository repository){
        return args ->{
           Property p1 = new Property(1,200,false,(byte)4,false,false,"floor",1,1);
            repository.save(p1);
        };
    }
}
