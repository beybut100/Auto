package com.example.Auto2.service;

import com.example.Auto2.dto.car.Auto;
import com.example.Auto2.dto.track.Dashboard;
import com.example.Auto2.dto.track.FuelConsumption;
import com.example.Auto2.dto.track.Indicates;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelService {
    List<Indicates> indicates=new ArrayList<>();

    public List<Indicates> getIndicates() {
        return indicates;
    }

    public void setIndicates(List<Indicates> indicates) {
        this.indicates = indicates;
    }

    public List<Object> CountConsumption() {
    List<Object> example = new ArrayList<>();
    for(int i=0;i<indicates.size();i++) {
        List<FuelConsumption> Total=new ArrayList<>();
        double usedFuel=0;
        Indicates elem = indicates.get(i);
        List<Dashboard> one=elem.getDashboard();
        Auto au=elem.getAuto();
        double standFuelConsInMet=au.getFuelСonsumption()/100000;
        for(int f=0;f<one.size();f++) {
            usedFuel += standFuelConsInMet;
                Total.add(new FuelConsumption(f, usedFuel, au.GetBrand_model()));
            }
        example.add(Total);
        }
        return example;
    }

    public double koefForFuel(String levelOfConsumption) {
        switch (levelOfConsumption) {
            case "veryTall": return 1.4;
            case "high": return 1.25;
            case "higher": return 1.12;
            case "lower": return 0.92;
            case "low": return 0.85;
            case "veryLowLevel": return 0.76;
            default: return 1;
        }
    }

}



