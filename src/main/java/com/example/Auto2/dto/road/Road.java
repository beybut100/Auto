package com.example.Auto2.dto.road;

import java.util.ArrayList;

public class Road {
    private ArrayList <Road_Object> Road=new ArrayList<>();
    public ArrayList<Road_Object> getRoad() {
        return Road;
    }

    public void AddElement(Road_Object ParticularObject) {
        if(Road.size()==0) {
            Road.add(ParticularObject);
        }
        else {
            if ((Road.get(Road.size()-1).getClass() != ParticularObject.getClass())) {
                Road.add(ParticularObject);
            }
        }
    }

    public void DeleteElement() {
        if(this.Road.isEmpty()) {
            return;
        }
        Road.remove(Road.size() - 1);
    }


    public Road() {

    }

    }

