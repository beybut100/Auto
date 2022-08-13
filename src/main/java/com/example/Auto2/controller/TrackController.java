package com.example.Auto2.controller;

import com.example.Auto2.dto.car.Auto;
import com.example.Auto2.dto.road.Road;
import com.example.Auto2.dto.road.RoadNotFound;
import com.example.Auto2.dto.track.Features;
import com.example.Auto2.dto.track.FuelConsumption;
import com.example.Auto2.dto.track.Indicates;
import com.example.Auto2.dto.user.SessionNotFound;
import com.example.Auto2.service.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Track;
import java.util.List;

@RestController
@RequestMapping(path="track")
public class TrackController {
    RoadService roadService;
    UserService userService;
    TrackService trackService;
    AutoService autoService;
    FuelService fuelService;
 @RequestMapping(path="simulation",headers = "Session")
 public List<Indicates> Simulation(@RequestHeader(name="Session") String id) throws Exception {
     if(!userService.IsExistSession(id)) {
         throw new SessionNotFound("Session not found");
     }
     List<Auto> listAuto=autoService.GetCars(id);
     Road road=roadService.GetRoad(id);


    return    trackService.Simualation(listAuto,road);
 }

 @RequestMapping(path="getfuel",headers = "Session")
    public List<Object> GetFuel(@RequestHeader(name="Session") String id) throws Exception {
        if(!userService.IsExistSession(id)) {
            throw new SessionNotFound("Session not found");
        }
   return   fuelService.CountConsumption();
 }


    public TrackController(RoadService roadService, UserService userService, TrackService trackService, AutoService autoService,FuelService fuelService) {
        this.roadService = roadService;
        this.userService = userService;
        this.trackService = trackService;
        this.autoService = autoService;
        this.fuelService=fuelService;
    }
}
