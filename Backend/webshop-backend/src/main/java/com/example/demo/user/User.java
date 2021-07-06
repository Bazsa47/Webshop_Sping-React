package com.example.demo.user;

import javax.persistence.*;

@Entity
@Table(
        name = "Advertiser",
        uniqueConstraints = {
            @UniqueConstraint(name = "UQ_user",columnNames = {
                    "userName","email","phone",
            })
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(nullable = false)
    private byte role;

    @Column(columnDefinition = "TEXT")
    private String profilePicture;

    @Column(columnDefinition = "TEXT")
    private String introduction;


    public User() {
    }

    public User(String userName, String fullName, String email, String phone, String password, byte role, String profilePicture, String introduction) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
        this.introduction = introduction;
    }

    public User(long userId, String userName, String fullName, String email, String phone, String password, byte role, String profilePicture, String introduction) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
        this.introduction = introduction;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", profilePicture='" + profilePicture + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
