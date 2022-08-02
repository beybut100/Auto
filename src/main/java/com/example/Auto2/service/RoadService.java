package com.example.Auto2.service;

import com.example.Auto2.dto.road.Road;
import com.example.Auto2.dto.road.RoadNotFound;
import com.example.Auto2.dto.road.Road_Object;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoadService {

    Map<String, Road> usersroad=new HashMap<>();

 public void CreateInitialRoad(String id) {
     usersroad.put(id,new Road());
 }
 public void CleanRoad(String id) {
     usersroad.clear();
 }

 public void Addelement(String id,Road_Object roadobject) {
     if(!usersroad.containsKey(id)) {
         CreateInitialRoad(id);
     }
   Road road=usersroad.get(id);
     road.AddElement(roadobject);
 }

 public void DeleteElement(String id) {
     if(!usersroad.containsKey(id)) {
         return;
     }
     Road road=usersroad.get(id);
     if(road==null) {
         return;
     }
     road.DeleteElement();
 }

 public Road GetRoad(String id) throws RoadNotFound {
     if(!usersroad.containsKey(id)) {
         throw new RoadNotFound("Road doen't exist");
     }
     Road road=usersroad.get(id);
     if(road==null) {
         throw new RoadNotFound("Road in empty");
     }
    return road;
 }



}
