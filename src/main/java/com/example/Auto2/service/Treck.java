package com.example.Auto2.service;

import com.example.Auto2.dto.car.Auto;
import com.example.Auto2.dto.road.Road_Object;
import com.example.Auto2.dto.road.Turn;
import com.example.Auto2.dto.road.Straightroad;
import com.example.Auto2.dto.track.Commands;
import com.example.Auto2.dto.track.Dashboard;
import com.example.Auto2.dto.track.Features;

import java.util.ArrayList;

public class Treck {
 //  com.example.Auto2.dto.road.Road a = new com.example.Auto2.dto.road.Road();
    ArrayList<Road_Object> road = new ArrayList<>();

    RecordsOfTrack FirstDaSH;

    public String GetStrategy() {
        String strategy;
        double result = Math.random();
        if (result < 0.5) {
            return strategy = "average";
        } else if (result >= 0.5 && result < 0.75) {
            return strategy = "active";
        } else if (result >= 0.75 && result < 1) {
            return strategy = "conservative";
        }
        return "strategy";
    }

 /*   public com.example.Auto2.dto.track.Features ChiefRegulator() {

    }; */

    private double DeviationKof(int lengthofpart) {
        switch (lengthofpart) {
            case 300:
                return 1.03;
            case 444:
                return 0.98;
            case 950:
                return 1.02;
            case 1300:
                return 1.01;
            case 1660:
                return 0.97;
            case 2700:
                return 1.02;
                     case 3400: return 0.95;
                    case 3999: return 0.98;
                    case 2999: return 0.97;
            case 3511:
                return 1.01;
            case 5600:
                return 0.98;
            case 8000:
                return 1.01;

            default:
                return 1.0;
        }
    }

    ;


    public Features LongDistanceAv(Features previous, Auto auto, Road_Object spec) throws Exception {

        double starspeed = previous.getCurrentSpeed();
        float TimeBefore = (float) previous.getTimeinSec();
        int DistanceBefore = previous.getPassedDistance();

// We take distance below;
        for (int i = 0; i < spec.getLengthinmeters(); i++) {
            if (starspeed > auto.speed - 0.1 * auto.speed || starspeed < auto.speed + 0.1 * auto.speed) {
                starspeed *= DeviationKof(i);
        //        System.out.println(starspeed);
            } else {
                throw new Exception();
            }
            DistanceBefore++;
            TimeBefore += 1 / (starspeed * 1000 / 3600);
      //      System.out.println(TimeBefore);
        }
        return new Features(DistanceBefore, starspeed, TimeBefore);
    }


    public Features FirstStage(Auto auto, Road_Object firstelem, String strategy, Commands other) {
        double starspeed = 0;
        float TimeBefore = 0;
        int DistanceBefore = -1;
        int k = 0;
        int test = 0;
        double SpecKof=0;
        switch (strategy) {
            case "active":  SpecKof=(10*Math.random());
            break;
            case "average": SpecKof=(-5+15*Math.random());
            break;
        case "conservative": SpecKof=(-10+10*Math.random());
        break;
        }
        for (int i = 0; i <= firstelem.getLengthinmeters(); i++) {

            while (starspeed < auto.speed+SpecKof&&i<=k) {
                starspeed = (Math.sqrt(2 * 0.8 * auto.getAcceleration() * i)) * 3600 / 1000;
                if(other.isTurnFor()) {
                    starspeed=SlowDown(firstelem.getLengthinmeters(),starspeed,DistanceBefore);
                }
                if (i > 0) {
                    TimeBefore += 1 / (starspeed * 1000 / 3600);
                }
                k++;
                break;
            }

            if (i >=k) {
                starspeed *= DeviationKof(test);
                if(other.isTurnFor()) {
                    starspeed=SlowDown(firstelem.getLengthinmeters(),starspeed,DistanceBefore);
                }
                TimeBefore += 1 / (starspeed * 1000 / 3600);
            }
            test++;
            DistanceBefore++;
            FirstDaSH.RecordIndicates(DistanceBefore,starspeed);

        }

        return new Features(DistanceBefore, starspeed, TimeBefore);

    }

    ;

    public Features Acceleration(Features previous, Auto auto, Road_Object spec, String strategy) {
        double starspeed = previous.getCurrentSpeed();
        float TimeBefore = (float) previous.getTimeinSec();
        int DistanceBefore = previous.getPassedDistance();
        float TimethisPart=0;
        double CorrecForAv = 20 * Math.random();
        double InitialSpeed=starspeed;
        double a=0;
        double b=0;
        switch (strategy) {
            case "average": a=-10+CorrecForAv;
            b=0.8;
            break;
            case "active": a=CorrecForAv;
            b=0.9;
            break;
            case "conservative": a=-CorrecForAv;
            b=0.7;
            break;
        }
        float difference=0;
        for (int i = 0; i < spec.getLengthinmeters(); i++) {
                if(starspeed<auto.speed+a) {

                    starspeed= Math.sqrt(2 *b * auto.getAcceleration()*i)*3600/1000+InitialSpeed;
                    if (i > 0) {
                        difference=TimethisPart;
                        TimethisPart =(float) ((starspeed - InitialSpeed)/ auto.getAcceleration());
                        difference=TimethisPart-difference;
                    }

                    TimeBefore+=difference;
                    DistanceBefore++;
                    FirstDaSH.RecordIndicates(DistanceBefore,starspeed);

                }
                   else {
                       return new Features(DistanceBefore,starspeed,TimeBefore);
                }

            }
            return new Features(DistanceBefore,starspeed,TimeBefore);
    }

    public Features LongDistanceAvS(Features previous, Auto auto, Road_Object spec, Commands command, String strategy) throws Exception {

        double starspeed = previous.getCurrentSpeed();
        float TimeBefore = (float) previous.getTimeinSec();
        int DistanceBefore = previous.getPassedDistance();
        double ComparableSpeed=0;
        switch (strategy) {
            case "average":
                ComparableSpeed=auto.speed;
                break;
            case "active":
                ComparableSpeed=auto.speed+20;
                break;
            case "conservative":
                ComparableSpeed=auto.speed-10;
                break;

        }
        if(starspeed<ComparableSpeed) {
                    Features AccbeMainDis=Acceleration(previous,auto,spec,strategy);
                    starspeed=AccbeMainDis.getCurrentSpeed();
                    TimeBefore= (float) AccbeMainDis.getTimeinSec();
             int    DistanceAfAcc=AccbeMainDis.getPassedDistance();
                    int DistanWithoutStart=spec.getLengthinmeters()-(DistanceAfAcc-DistanceBefore);
                    for(int i=0;i<DistanWithoutStart; i++) {
                        starspeed *= DeviationKof(i);
                        DistanceAfAcc++;
                        TimeBefore += 1 / (starspeed * 1000 / 3600);
                        if(command.isTurnFor()) {
                        starspeed=SlowDown(DistanWithoutStart,starspeed,i); }
                        FirstDaSH.RecordIndicates(DistanceAfAcc,starspeed);
                    }
                    return new Features(DistanceAfAcc,starspeed,TimeBefore);
                }
                else {
                    for (int i = 0; i < spec.getLengthinmeters(); i++) {
                        starspeed*=DeviationKof(i);
                        DistanceBefore++;
                        TimeBefore+= 1 / (starspeed * 1000 / 3600);
                        if(command.isTurnFor()) {
                            starspeed=SlowDown(spec.getLengthinmeters(), starspeed,i); }
                        FirstDaSH.RecordIndicates(DistanceBefore,starspeed);
                    }
                return new Features(DistanceBefore,starspeed,TimeBefore);
                }

    }


    private double SlowDown(int Distance, double starspeed, int passed) {
        int LeftDistance=Distance-passed;
        switch (LeftDistance) {
            case 150: return starspeed*=0.5;
            case 100: return  starspeed*=0.8;
            case 80: return starspeed*=0.7;
            case 50: return starspeed*=0.5;
            case 1: return starspeed=3;

        }
 return starspeed;
    }


    public Features MainRegulare(Auto a ) throws Exception {
    Features Initial=null;
    Commands Forturn=new Commands(true);
    Commands WithoutTurn=new Commands(false);
    String ChosenStategy=GetStrategy();
    System.out.println("System randomly chose "+ChosenStategy);
    for(int i=0;i<road.size(); i++) {
        if(road.size()==1) {
            Initial = FirstStage(a, road.get(0), ChosenStategy, WithoutTurn);
        }
        if (i <= road.size() - 2) {
            if (road.get(i + 1).getClass() != Turn.class && road.get(i).getClass() == Straightroad.class) {
                if (i == 0) {
                    Initial = FirstStage(a, road.get(0), ChosenStategy, WithoutTurn);
                } else if (i == road.size() - 1) {
                    Initial = LongDistanceAvS(Initial, a, road.get(i), WithoutTurn, ChosenStategy);
                } else {
                    Initial = LongDistanceAvS(Initial, a, road.get(i), WithoutTurn, ChosenStategy);
                }
            }
            if (road.get(i + 1).getClass() == Turn.class && road.get(i).getClass() == Straightroad.class) {
                if (i == 0) {
                    Initial = FirstStage(a, road.get(0), ChosenStategy, Forturn);
                } else {
                    Initial = LongDistanceAvS(Initial, a, road.get(i), Forturn, ChosenStategy);
                }
            }
        }
        else if (i==(road.size() - 1)&&i!=0){
        if(road.get(i).getClass()== Straightroad.class) {
            Initial = LongDistanceAvS(Initial, a, road.get(i), WithoutTurn, ChosenStategy);
        }
            }
        }
        FirstDaSH.ShowIndicates();
        return Initial;


    };

    public Treck(ArrayList<Road_Object> road) {
        this.road = road;
    }


}






















