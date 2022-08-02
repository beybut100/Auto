package com.example.Auto2.dto.road;

import org.springframework.beans.factory.annotation.Autowired;

public class Straightroad extends Road_Object  {

    @Override
    public int getDistance() {
     return   getLengthinmeters();
    };

    @Autowired
    public Straightroad(int lengthinmeters) {
        super.lengthinmeters=lengthinmeters;

    }
}



