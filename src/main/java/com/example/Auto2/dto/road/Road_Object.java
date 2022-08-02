package com.example.Auto2.dto.road;

import com.example.Auto2.dto.car.Auto;

public class Road_Object  {
    int lengthinmeters;
    double speed;
    public int getDistance() {
        return getLengthinmeters();
    }
    public int getLengthinmeters() {
      return lengthinmeters;
    };

    public Road_Object() {
    }
}

