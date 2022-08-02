package com.example.Auto2.dto.track;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    private int distance;

    public String toString() {
        return "speed: "+this.speed+" distance: "+this.distance;
    }



    public Dashboard(double speed, int distance) {
        this.speed = speed;
        this.distance=distance;

    }


}
