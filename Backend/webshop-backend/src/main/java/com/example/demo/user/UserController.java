package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

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



}
