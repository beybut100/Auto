package com.example.Auto2.dto.user.Registration;


import com.example.Auto2.dto.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name="LoginAndPassword")
@Entity

public class LoginAndPassword {
    @Column(name="login")
    String login;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name="id",columnDefinition = "varchar")
    String id;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
@Column(name="password")
    public String password;
    @Column(name="hash")
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
