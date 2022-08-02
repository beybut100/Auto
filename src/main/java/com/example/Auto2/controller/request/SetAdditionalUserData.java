package com.example.Auto2.controller.request;

public class SetAdditionalUserData {
    String email;

    public String getEmail() {
        return email;
    }

    public SetAdditionalUserData(String email) {
        this.email = email;
    }

    public SetAdditionalUserData() {
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
