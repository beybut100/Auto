package com.example.Auto2.controller;

import com.example.Auto2.controller.request.AddRoadObject;
import com.example.Auto2.dto.road.*;
import com.example.Auto2.dto.user.SessionNotFound;
import com.example.Auto2.service.RoadService;
import com.example.Auto2.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="roads")
public class RoadController {
    RoadService roadService;
    UserService userService;

@RequestMapping(value="/create",headers = "Session" )
public void Create(@RequestHeader(name="Session") Integer id) throws SessionNotFound {
    if(!userService.IsExistSession(id)) {
        throw new SessionNotFound("Session not found");
    }
    roadService.CreateInitialRoad(id);
}
@RequestMapping(value="/getroad",headers = "Session" )
public Road GetRoad(@RequestHeader(name="Session") Integer id) throws SessionNotFound, RoadNotFound {
    if(!userService.IsExistSession(id)) {
        throw new SessionNotFound("Session not found");
    }
    return roadService.GetRoad(id);
}

@RequestMapping(value="/addelement",headers = "Session")
public void AddElement(@RequestHeader(name="Session") Integer id, @RequestBody AddRoadObject add) {
    if(add.getTypeofroadobj().equals("straightroad")) {
        roadService.Addelement(id,new Straightroad(add.getLengthinmeters()));
    }
    if(add.getTypeofroadobj().equals("Turn")) {
        roadService.Addelement(id,new Turn());
    }
}




    public RoadController(RoadService roadService,UserService userService) {
        this.roadService = roadService;
        this.userService=userService;
    }
}
