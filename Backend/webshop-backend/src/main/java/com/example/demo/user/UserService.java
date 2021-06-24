package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void registerUser(User u) {
        userRepository.save(u);
    }

    @Transactional
    public void updateUser(long userId, String userName, String fullName, String email, String phone, String profilePicture, String introduction) {
        //if not null, "", or same as previous
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User id does not exist!"));
        user.setUserName(userName);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(phone);
        user.setProfilePicture(profilePicture);
        user.setIntroduction(introduction);
    }

    public void deleteuser(long userId) {
        userRepository.deleteById(userId);
    }
}
