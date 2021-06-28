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
           Property p1 = new Property(1300000,200,false,(byte)4,false,false,"floor",1,1);
           Property p2 = new Property(4500000,300,true,(byte)6,true,true,"floor",1,2);
           Property p3 = new Property(2450000,450,true,(byte)10,true,true,"floor",1,3);
           Property p4 = new Property(1500000,100,false,(byte)3,false,false,"yes",1,4);
           Property p5 = new Property(30000000,145,true,(byte)5,false,true,"floor",1,5);
           Property p6 = new Property(5000000,200,true,(byte)4,true,true,"floor",1,6);
           Property p7 = new Property(5000000,200,true,(byte)4,true,true,"floor",1,7);
           Property p8 = new Property(5000000,200,true,(byte)4,true,true,"floor",1,8);
           repository.saveAll(List.of(p1,p2,p3,p4,p5,p6,p7,p8));
        };
    }
}
