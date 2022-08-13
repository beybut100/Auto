package com.example.Auto2.dto.track;

import com.example.Auto2.dto.car.Auto;

import java.util.List;

public class Indicates {

    Features features;
    List<Dashboard> dashboard;
    Auto auto;

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public List<Dashboard> getDashboard() {
        return dashboard;
    }

    public void setDashboard(List<Dashboard> dashboard) {
        this.dashboard = dashboard;
    }

    public Indicates(Features features, List<Dashboard> dashboard,Auto auto) {
        this.features = features;
        this.dashboard = dashboard;
        this.auto=auto;
    }
}
