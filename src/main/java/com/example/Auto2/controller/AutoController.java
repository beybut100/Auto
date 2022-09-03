package com.example.Auto2.controller;

import com.example.Auto2.controller.request.InfoForAuto;
import com.example.Auto2.dto.car.Auto;
import com.example.Auto2.dto.car.AutoAlreadyExists;
import com.example.Auto2.dto.user.SessionNotFound;
import com.example.Auto2.service.AutoService;
import com.example.Auto2.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path="auto")
public class AutoController {

    AutoService autoService;
    UserService userService;

@RequestMapping(path="/addautotorepository",headers = "Session")
    public Auto InsertAutoinRepository(@RequestHeader(name="Session") Integer id, @RequestBody InfoForAuto info) throws AutoAlreadyExists, SessionNotFound {
    if(!userService.IsExistSession(id)) {
        throw new SessionNotFound("Session not found");
    }
  return  autoService.AddAutotoRepository(info);
}

@RequestMapping(path="/start",headers = "Session")
public void StartGame(@RequestHeader(name="Session") Integer id) throws SessionNotFound {
    if(!userService.IsExistSession(id)) {
        throw new SessionNotFound("Session not found");
    }
    autoService.CreateCollectionofCars(id);
}

@RequestMapping(path="createnewcar",headers = "Session")
public void NewAuto(@RequestBody InfoForAuto info,@RequestHeader(name="Session") Integer id) throws SessionNotFound {
    if(!userService.IsExistSession(id)) {
        throw new SessionNotFound("Session not found");
    }
    autoService.CreateNewAuto(info,id);
}

@RequestMapping(path="getallcars",headers = "Session")
public ArrayList<Auto> GetAllcars(@RequestHeader(name="Session") Integer id) throws SessionNotFound {
    if(!userService.IsExistSession(id)) {
        throw new SessionNotFound("Session not found");
    }
 return   autoService.GetCars(id);
}
@RequestMapping(path="/deleteeverything",headers = "Session")
    public void DeleteAll(@RequestHeader(name="Session") Integer id) throws SessionNotFound {
        if(!userService.IsExistSession(id)) {
            throw new SessionNotFound("Session not found");
        }
        autoService.ClearCollection();
    }

    public AutoController(AutoService autoService, UserService userService) {
        this.autoService = autoService;
        this.userService = userService;
    }
}
