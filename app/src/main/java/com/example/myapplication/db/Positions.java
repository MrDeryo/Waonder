package com.example.myapplication.db;

import com.google.android.gms.maps.model.LatLng;

public class Positions {
        private String username;
        private double lat;
        private double lon;

        public Positions(String username,double lat,double lon) {
            this.username= username;
            this.lat = lat;
            this.lon = lon;

        }
    public String getUsername() {
        return username;
    }

    public void setText(String username) {
        this.username = username;
    }

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat= lat;
        }
    public double getLon() {
        return lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }


}
