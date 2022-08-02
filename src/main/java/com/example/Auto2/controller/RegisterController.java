package com.example.Auto2.controller;

import com.example.Auto2.controller.request.SetAdditionalUserData;
import com.example.Auto2.dto.user.*;
import com.example.Auto2.dto.user.Registration.*;
import com.example.Auto2.service.StoreRegisterForm;
import com.example.Auto2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "registration")
public class RegisterController {
    @Autowired
    StoreRegisterForm storeregisterform;
    @Autowired
    UserService userservice;
@RequestMapping(path = "/saveform",method = RequestMethod.POST)
public LoginAndPassword Save(@RequestParam String login, @RequestParam String password ) throws NoSuchAlgorithmException, InvalidPassword, InvalidLogin {

    return storeregisterform.SaveRegForm(login,password);
}
@RequestMapping(path="/Authorized",method =RequestMethod.POST)
    public Session Authorized(@RequestParam String login, @RequestParam String password) throws InvalidLogin, UserNotFound, IncorrectPassword {
    return storeregisterform.getAuthorized(login,password);
}

@RequestMapping(path="/CloseSession",method=RequestMethod.POST)
    public void CloseSession(@RequestParam String id) {
    storeregisterform.CloseSession(id);
}

@RequestMapping(path="/SetLocation/{sessionId}",method=RequestMethod.POST)
public void SetLocation(@RequestBody Location location, @PathVariable(name="sessionId")String sessionId) throws SessionNotFound {
        storeregisterform.SetLocation(sessionId,location);
}

@RequestMapping(path="/SearchMeaning",method=RequestMethod.GET)
    public void GetElementBySearch(@RequestParam int timetodelete) {
    storeregisterform.DeleteOldSessions(timetodelete);
}

@RequestMapping(path="/users/SetUserData",method=RequestMethod.POST,headers = "Session")
    public User SaveUser(@RequestBody SetAdditionalUserData set, @RequestHeader ("Session")String session ) throws  SessionNotFound, LocationNotDetectedException {
  return      userservice.SaveUserData(session, set.getEmail());
}

}
