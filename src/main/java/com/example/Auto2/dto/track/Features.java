package com.example.Auto2.dto.track;

import java.util.ArrayList;

public class Features {
        int PassedDistance;
        double CurrentSpeed;
        double TimeinSec;

        public int getPassedDistance() {
                return PassedDistance;
        }

        public void setPassedDistance(int passedDistance) {
                PassedDistance = passedDistance;
        }

        public double getCurrentSpeed() {
                return CurrentSpeed;
        }

        public void setCurrentSpeed(double currentSpeed) {
                CurrentSpeed = currentSpeed;
        }

        public double getTimeinSec() {
                return TimeinSec;
        }

        public void setTimeinSec(double timeinSec) {
                TimeinSec = timeinSec;
        }

        public Features(int PassedDistance, double CurrentSpeed, float TimeinSec) {
                this.PassedDistance=PassedDistance;
                this.CurrentSpeed=CurrentSpeed;
                this.TimeinSec=TimeinSec;
        }

}
