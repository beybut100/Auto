package com.example.Auto2.dto.user;


import javax.persistence.Id;

public class User {
    @Id
   private String login;
    String email;
    Location location;
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public User(String login, String email, Location location) {
        this.login = login;
        this.email = email;
        this.location=location;
    }

    public User() {
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
