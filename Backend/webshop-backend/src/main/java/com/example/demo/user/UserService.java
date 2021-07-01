package com.example.demo.user;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    public boolean isValid(String value){
        return value != null && value.trim() != "";
    }

    public boolean isEmail(String email){
        return EmailValidator.getInstance().isValid(email);
    }

    public Optional<User> getUserById(long userId) {
        if (!userRepository.findById(userId).isPresent()) throw new  IllegalStateException("User id does not exist!");
        return userRepository.findById(userId);
    }


    public void uploadProfilePicture(long userId, MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new IllegalStateException("Can not upload empty file");
        //if (!Arrays.asList(ContentType.IMAGE_JPEG,ContentType.IMAGE_PNG,ContentType.IMAGE_GIF,ContentType.IMAGE_SVG).contains(file.getContentType())) throw new IllegalStateException("Not an image");
        if (userRepository.findById(userId).isEmpty()) throw new IllegalStateException("User does not exist");

        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-Type",file.getContentType());
        metaData.put("Content-Length",String.valueOf(file.getSize()));

        String folder = "C:\\Users\\balaz\\OneDrive\\Asztali gép\\Projektek\\Webshop_Spring-React\\Backend\\webshop-backend\\src\\main\\resources\\img\\";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder +generateRandomString(15) + ".png");
        Files.write(path,bytes);
        updateUserProfilePicture(userId,path.toString());
    }

    @Transactional
    public void updateUserProfilePicture(Long userId, String path){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("No such user"));
        user.setProfilePicture(path);
    }

    private String generateRandomString(int size){
        String input = "abcdefghijklmnopqrstuvwxyz0123456789";
        String output = "";
        for (int i = 0; i < size; i++) {
            output += input.charAt(new Random().nextInt(input.length()));
        }

        return output;
    }
}
