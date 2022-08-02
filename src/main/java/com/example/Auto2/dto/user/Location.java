package com.example.Auto2.dto.user;

public class Location {
    String Latitude;
    String Longitude;

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public Location(String Latitude, String Longitude) {
        this.Latitude=Latitude;
        this.Longitude=Longitude;

    }
}
