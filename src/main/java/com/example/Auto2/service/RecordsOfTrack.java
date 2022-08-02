package com.example.Auto2.service;

import com.example.Auto2.dto.track.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class RecordsOfTrack {
    private List<Dashboard> AllIndicates = new ArrayList<>();

    public void RecordIndicates (int distance, double speed) {
        AllIndicates.add(new Dashboard(speed,distance));
    }

    public void ShowIndicates() throws Exception {
        int b=0;


        for(int i=0; i<=AllIndicates.size();i=i+b) {
            int speedformatted= (int) Math.round(AllIndicates.get(i).getSpeed());
            if(i<0.2*Math.round(AllIndicates.size())) {
                b=100;
                System.out.println("\r"+"Passed distance: "+AllIndicates.get(i).getDistance()+"    Speed:"+speedformatted);
                //       Thread.sleep(2000);
            }
            if(0.2*Math.round(AllIndicates.size())<i&&i<0.9*Math.round(AllIndicates.size())) {
                b=600;
                System.out.println("\r"+"Passed distance: "+AllIndicates.get(i).getDistance()+"    Speed:"+speedformatted);
                //       Thread.sleep(1500);
            }
            if(0.9*Math.round(AllIndicates.size())<i) {
                b=150;
                System.out.println("\r"+"Passed distance: "+AllIndicates.get(i).getDistance()+"    Speed:"+speedformatted);
                //    Thread.sleep(1500);
            }

        }
        AllIndicates.removeAll(AllIndicates);
    };
}
