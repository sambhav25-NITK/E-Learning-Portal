package com.example.techademy.Admin;

public class AdminLoginAttribute {
    private String username;
    private String password;

    public AdminLoginAttribute() {
    }

    public AdminLoginAttribute(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminLoginAttribute{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
