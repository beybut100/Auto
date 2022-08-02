package com.example.Auto2.dto.user.Registration;

public class InvalidLogin extends Exception {

    int loginConditionViolated=0;
    String message;
public InvalidLogin (int conditionViolated) {
    loginConditionViolated=conditionViolated;
     message=PrintMessage();

}

    public int getLoginConditionViolated() {
        return loginConditionViolated;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String PrintMessage() {
    switch (loginConditionViolated) {
        case 1: return ("Login length should be between 6-12 letter");
        case 2: return ("Login already exists");
        case 3: return ("Incorrect symbols");
    }
        return("Other problem with login");
    }

}
