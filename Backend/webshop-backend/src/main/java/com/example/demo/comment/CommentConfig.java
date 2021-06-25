package com.example.demo.comment;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommentConfig {
    @Bean(name = "commentconf")
    CommandLineRunner commandLineRunner(CommentRepository repository){
        return args ->{
            Comment c1 = new Comment(1,1,"very big ház",0);
            Comment c2 = new Comment(1,2,"nem lyó ház",0);
            repository.saveAll(List.of(c1,c2));
        };
    }
}
