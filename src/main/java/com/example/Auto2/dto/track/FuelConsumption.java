package com.example.Auto2.dto.track;

import com.example.Auto2.dto.car.Auto;

public class FuelConsumption {
    int distance;

    double fuelConsumption;

    String nameOfCar;

    public String getNameOfCar() {
        return nameOfCar;
    }

    public void setNameOfCar(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public FuelConsumption(int distance, double fuelConsumption,String nameOfCar) {
        this.distance = distance;
        this.fuelConsumption = fuelConsumption;
        this.nameOfCar=nameOfCar;
    }
}
