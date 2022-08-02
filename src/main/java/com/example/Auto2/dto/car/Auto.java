package com.example.Auto2.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Auto {
@Id
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public    double speed;
    int power;
    double FuelСonsumption;
    boolean AWD;
    int SizeofVehicleBase;
    int price;

    double acceleration;

    String brandModel;

    public String getBrandModel() {
        return brandModel;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @JsonProperty("fuel_consumption")
    public double getFuelСonsumption() {
        return FuelСonsumption;
    }

    public void setFuelСonsumption(double fuelСonsumption) {
        FuelСonsumption = fuelСonsumption;
    }
    @JsonProperty("AWD")
    public boolean isAWD() {
        return AWD;
    }

    public void setAWD(boolean AWD) {
        this.AWD = AWD;
    }

    public int getSizeofVehicleBase() {
        return SizeofVehicleBase;
    }

    public void setSizeofVehicleBase(int sizeofVehicleBase) {
        SizeofVehicleBase = sizeofVehicleBase;
    }

    public int getPrice() {
        return price;
    }

    public double getAcceleration() {
        return acceleration;
    }
    public void setAcceleration(double acceleration) {
        this.acceleration=acceleration;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String GetBrand_model() {
        return brandModel;
    };

    public Auto(double speed, int power, double fuelСonsumption, boolean AWD, int sizeofVehicleBase, int price, double acceleration, String brandModel) {
        this.speed = speed;
        this.power = power;
        FuelСonsumption = fuelСonsumption;
        this.AWD = AWD;
        SizeofVehicleBase = sizeofVehicleBase;
        this.price = price;
        this.acceleration = acceleration;
        this.brandModel = brandModel;
    }

    public Auto () {

    }

}



