package com.example.Auto2.dto.track;

import java.util.List;

public class Indicates {

    Features features;
    List<Dashboard> dashboard;

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

    public Indicates(Features features, List<Dashboard> dashboard) {
        this.features = features;
        this.dashboard = dashboard;
    }
}
