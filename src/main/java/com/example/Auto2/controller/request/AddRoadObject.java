package com.example.Auto2.controller.request;

public class AddRoadObject {

    int lengthinmeters;
    private String typeofroadobj;

    public int getLengthinmeters() {
        return lengthinmeters;
    }

    public void setLengthinmeters(int lengthinmeters) {
        this.lengthinmeters = lengthinmeters;
    }

    public String getTypeofroadobj() {
        return typeofroadobj;
    }

    public void setTypeofroadobj(String typeofroadobj) {
        this.typeofroadobj = typeofroadobj;
    }

    public AddRoadObject(int lengthinmeters, String typeofroadobj) {
        this.lengthinmeters = lengthinmeters;
        this.typeofroadobj = typeofroadobj;
    }

    public AddRoadObject(String typeofroadobj) {

        this.typeofroadobj = typeofroadobj;
    }

    public AddRoadObject() {
    }
}
