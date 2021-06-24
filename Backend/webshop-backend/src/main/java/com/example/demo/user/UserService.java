package com.example.demo.user;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public void registerUser(User u) throws NoSuchAlgorithmException {
        u.setPassword(hashPassword(u.getPassword()));
        userRepository.save(u);
    }

    @Transactional
    public void updateUser(long userId, String userName, String fullName, String email, String phone, String password, String profilePicture, String introduction) throws NoSuchAlgorithmException {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User id does not exist!"));
        if (isValid(userName) && userName != user.getUserName()) user.setUserName(userName);
        if (isValid(fullName) && fullName != user.getFullName()) user.setFullName(fullName);
        if (isValid(email) && email != user.getEmail() && isEmail(email)) user.setEmail(email);
        if (isValid(phone) && phone != user.getPhone()) user.setPhone(phone);
        if (isValid(password)) user.setPassword(hashPassword(password));
        if (isValid(profilePicture) && profilePicture != user.getProfilePicture()) user.setProfilePicture(profilePicture);
        if (isValid(introduction) && introduction != user.getIntroduction()) user.setIntroduction(introduction);
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
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

    public void deleteUser(long userId) {
        if (!userRepository.findById(userId).isPresent()) throw new IllegalStateException("No such id.");
        userRepository.deleteById(userId);
    }

    private boolean isValid(String value){
        return value != null && value.trim() != "";
    }

    private boolean isEmail(String email){
        return EmailValidator.getInstance().isValid(email);
    }
}
