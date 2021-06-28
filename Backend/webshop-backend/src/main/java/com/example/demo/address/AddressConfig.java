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
           Address a1 = new Address(1,"Hungary","Felsőtárkány","Virág","9");
            Address a2 = new Address(2,"Hungary","Eger","Virág","9");
            Address a3 = new Address(3,"Hungary","Maklár","Virág","9");
            Address a4 = new Address(4,"Hungary","Parád","Virág","9");
            Address a5 = new Address(5,"Hungary","Recsk","Virág","9");
            Address a6 = new Address(6,"Hungary","Ózd","Virág","9");
            Address a7 = new Address(7,"Hungary","Demjén","Virág","9");
            Address a8 = new Address(8,"Hungary","Sirok","Virág","9");
           repository.saveAll(List.of(a1,a2,a3,a4,a5,a6,a7,a8));
        };
    }
}
