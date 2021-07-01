package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public Optional<User> getUserById(@PathVariable("userId") long userId){
        return userService.getUserById(userId);
    }

    @PostMapping
    public void registerUser(@RequestBody User u) throws NoSuchAlgorithmException {
        userService.registerUser(u);
    }

    @PutMapping(path="{userId}")
    public void updateUser(@PathVariable("userId") long userId,
                           @RequestParam(required = false) String userName,
                           @RequestParam(required = false) String fullName,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String phone,
                           @RequestParam(required = false) String password,
                           @RequestParam(required = false) String profilePicture,
                           @RequestParam(required = false) String introduction) throws NoSuchAlgorithmException {
        userService.updateUser(userId,userName,fullName,email,phone,password,profilePicture,introduction);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") long userId){
        userService.deleteUser(userId);
    }

    @PostMapping(path = "{userId}/img/upload" ,consumes =  MediaType.MULTIPART_FORM_DATA_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public void uploadProiflePicture(@PathVariable("userId") long userId,
                                     @RequestParam("file")MultipartFile file) throws IOException {
        userService.uploadProfilePicture(userId,file);

    }



}
