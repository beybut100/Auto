package com.example.Auto2.controller.request;

public class InfoForAuto {
    double speed;
    int power;
    double fuelСonsumption;
    boolean AWD;
    int sizeofVehicleBase;
    int price;
    double acceleration;
    String brandModel;

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

    public double getFuelСonsumption() {
        return fuelСonsumption;
    }

    public void setFuelСonsumption(double fuelСonsumption) {
        this.fuelСonsumption = fuelСonsumption;
    }

    public boolean isAWD() {
        return AWD;
    }

    public void setAWD(boolean AWD) {
        this.AWD = AWD;
    }

    public int getSizeofVehicleBase() {
        return sizeofVehicleBase;
    }

    public void setSizeofVehicleBase(int sizeofVehicleBase) {
        this.sizeofVehicleBase = sizeofVehicleBase;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public InfoForAuto(double speed, int power, double fuelСonsumption, boolean AWD, int sizeofVehicleBase, int price, double acceleration, String brandModel) {
        this.speed = speed;
        this.power = power;
        this.fuelСonsumption = fuelСonsumption;
        this.AWD = AWD;
        this.sizeofVehicleBase = sizeofVehicleBase;
        this.price = price;
        this.acceleration = acceleration;
        this.brandModel = brandModel;
    }
}
