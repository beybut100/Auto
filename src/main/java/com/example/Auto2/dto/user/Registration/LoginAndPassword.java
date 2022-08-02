package com.example.Auto2.dto.user.Registration;

import com.example.Auto2.dao.LoginPasswords;
import com.example.Auto2.dto.user.User;
import org.springframework.stereotype.Service;

public class LoginAndPassword {
    User user;
    String login;
   public String password;
   byte[] salt;

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getSalt() {
        return salt;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
LoginPasswords repository;


    public LoginAndPassword(String login, String password, byte[] salt) {
        this.login = login;
        this.password = password;
        this.salt=salt;

    }

    @Override
    public String toString() {
        return "ToRegister{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public LoginAndPassword( ){
    }
}
