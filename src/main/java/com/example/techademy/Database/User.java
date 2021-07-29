package com.example.techademy.Database;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private LocalDate regDate;
    private String uploadPhoto;
    private String role;

    public User() {
    }

    public User(Long userId, String name, String email, String password, String phone, String address, LocalDate regDate, String uploadPhoto, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.regDate = regDate;
        this.uploadPhoto = uploadPhoto;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getUploadPhoto() {
        return uploadPhoto;
    }

    public void setUploadPhoto(String uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", regDate=" + regDate +
                ", uploadPhoto='" + uploadPhoto + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
