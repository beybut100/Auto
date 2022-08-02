/*
package com.example.Auto2.service;

import com.example.Auto2.dto.car.Auto;
import com.example.Auto2.dto.car.BMW;
import com.example.Auto2.dto.road.Road;
import com.example.Auto2.dto.road.Turn;
import com.example.Auto2.dto.road.Straightroad;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;

public class GetDataFromuser {
    Scanner TypeRoadObj = new Scanner(System.in);
    ObjectMapper objectMapper = new ObjectMapper();
    private Road road;


    public int GetTypeofRoad_object() {
        System.out.println("Choose type of road object,please. Enter needed number: 1)com.example.Auto2.dto.road.straightroad 2)turn: ");
        String first = TypeRoadObj.nextLine();
        System.out.println("you enetered" + " " + first);
        try {
            int number = Integer.parseInt(first);
            if (number == (int) number) {
                return number;
            }

        } catch (NumberFormatException e) {
            System.out.println("Enter correct number!");
        } catch (Exception e) {
            System.out.println("Unknown error was occurred: " + e.getMessage());
        }
        return 0;
    }


    ;

    public int GetDistanceforStraightroad() {
        System.out.println("Enter length of com.example.Auto2.dto.road.straightroad ");
        String second = TypeRoadObj.nextLine();
        System.out.println("Enteded length of plot" + " " + second);
        try {
            int number = Integer.parseInt(second);
            if (number == (int) number) {
                return number;
            }

        } catch (NumberFormatException e) {
            System.out.println("Enter correct number!");
        } catch (Exception e) {
            System.out.println("Unknown error was occurred: " + e.getMessage());
        }
        return 0;
    }

    public int GetAnswer() {
        System.out.println("Do you want to continue adding elements. If yes press 1. If no press 2 ");
        String third = TypeRoadObj.nextLine();
        System.out.println("Entered number: " + third);
        try {
            int number = Integer.parseInt(third);
            if (number == (int) number) {
                return number;
            }


        } catch (NumberFormatException e) {
            System.out.println("Enter correct number!");
        } catch (Exception e) {
            System.out.println("Unknown error was occurred: " + e.getMessage());
        }
        return 0;
    }

    private int GetAnswer1() {
        String AnsweronTurn = TypeRoadObj.nextLine();
        System.out.println("Entered number: " + AnsweronTurn);
        try {
            int number = Integer.parseInt(AnsweronTurn);
            if (number < 3 && number != 0) {
                return number;
            }
            else {

                class OutofPossibleNumber extends Exception {
                    OutofPossibleNumber(String message) {
                            super(message);
                        }
                    }

            try {
                throw new OutofPossibleNumber("Number is more than 2 or equal to 0");
            }
            catch (OutofPossibleNumber e) {
                System.out.println("Please enter 1 or 2. Other options are blocked");
                GetAnswer1();
            }

            }

        } catch (NumberFormatException e) {
            System.out.println("Enter correct number! 1 or 2");
            GetAnswer1();
        } catch (Exception e) {
            System.out.println("Unknown error was occurred: " + e.getMessage());
        }
        return 0;
    }

    public Road UpRoad() {
        int Turncount=0;
        int TotalLength=0;
        System.out.println("First element in road is com.example.Auto2.dto.road.straightroad");
        TotalLength=GetDistanceforStraightroad();
        road.AddElement(new Straightroad(TotalLength));
        while (true) {
            if (TotalLength<700000) {
                System.out.println("Do you want to add turn to your road?If yes - press 1,if no - press - 2 ");
                int decision = GetAnswer1();
                if (decision == 1) {
                    road.AddElement(new Turn());
                    Turncount++;
                    int GotAnswer = GetAnswer();
                    if (GotAnswer == 1) {
                        int interval = GetDistanceforStraightroad();
                        road.AddElement(new Straightroad(interval));
                        TotalLength += interval;

                    } else {
                        System.out.println("Your road has " + Turncount + " turn(s) and total lenght is: " + TotalLength);
                        return road;
                    }
                } else {
                    System.out.println("Your road has " + Turncount + " turn(s) and total lenght is: " + TotalLength);
                    return road;

                }
            }
            else {
                road.DeleteElement();
                System.out.println("You cannot have distance more than 700000 meters. Please enter right size. Max - "+
                        (700000-TotalLength));


                road.AddElement(new Straightroad(GetDistanceforStraightroad()));
            }
        }
    };





    public GetDataFromuser(Road road) {
        this.road = road;
    }

    public Road getRoad() {
        return road;
    }


    public ArrayList<Auto> ChoseCar() {
        ArrayList<Auto> cars=new ArrayList<>();
        int NumberofAddCars=0;
        while(NumberofAddCars<5) {
            System.out.println("You may chose default car or create your own auto. To chose com.example.Auto2.dto.car.BMW press 1,to create new press 2(You may add maximum five cars");
            try{
            int fourth = Integer.parseInt(TypeRoadObj.nextLine());
            if(fourth==1) {
                    cars.add(new BMW());
            } else if (fourth==2) {
                cars.add(CreateNewCar());
            } }
            catch (NumberFormatException e) {
                System.out.println("Enter 1 or 2");
                continue;
            }

            NumberofAddCars++;
            if(NumberofAddCars>=1) {
                System.out.println("Do you want to continue adding cars? 1-yes,2-no");
                int Answer=Integer.parseInt(TypeRoadObj.nextLine());
                if(Answer==1) {
                    continue;
                }
                else {
                    return cars;
                }
            }
        }
        System.out.println(cars.size());
        return cars;
    }

    ;

    public Auto CreateNewCar() {
        Auto a = new Auto();
        while (true) {
            try {
                System.out.println("Please, enter brand and model of car");
                String fifth = TypeRoadObj.nextLine();
                try {
                   InputToCompare(fifth);
                    System.out.println("Do you want to add "+InputToCompare(fifth).brand_model+" "+"If yes press 1, if no press 2" );
                    String AskWhether=TypeRoadObj.nextLine();
                    if(AskWhether.equals("1")) {
                        System.out.println("You chose"+" "+InputToCompare(fifth).brand_model);
                        return InputToCompare(fifth);
                    }
                }
                catch (Exception e) {

                a.setBrand_model(fifth); }
            } catch (Exception ex) {
                System.out.println("Please, enter brand and model of car");
                continue;
            }

            break;
        }

        while (true) {
            try {
                System.out.println("Please,enter speed in km per hour");
                double seventh = Double.parseDouble(TypeRoadObj.nextLine());
                a.setSpeed(seventh);
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter integer or double number");
                continue;
            }

            break;
        }

        while (true) {
            try {
                System.out.println("Enter power of car");
                int eighth = Integer.parseInt(TypeRoadObj.nextLine());
                a.setPower(eighth);
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter integer number");
                continue;
            }

            break;
        }

        while (true) {
            try {
                System.out.println("Does this car have AWD?. 1-yes,or 2-no? ");
                int eighth = Integer.parseInt(TypeRoadObj.nextLine());
                if (eighth == 1) {
                    a.setAWD(true); }
                 else if (eighth == 2) {
                        a.setAWD(false);
                    }

            }
                catch (NumberFormatException ex) {
                System.out.println("Please, enter integer number 1 or 2");
                continue;
            }

            break;
        }


        while (true) {
            try {
                System.out.println("Enter fuel consumption per 100 km in mixed cycle");
                double ninth = Double.parseDouble(TypeRoadObj.nextLine());
                a.setFuelСonsumption(ninth);
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter integer or double number");
                continue;
            }

            break;
        }
        while (true) {
            try {
                System.out.println("Enter acceleration in second from 0 to 100 km/h");
                double ten = Double.parseDouble(TypeRoadObj.nextLine());
                double tenturntosecond=27.77/ten;
                a.setAcceleration(tenturntosecond);
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter integer or double number");
                continue;
            }

            break;
        }


        System.out.println(a.acceleration);

        return a;
    }

    List<Auto> cars = null;

    public List<Auto> ReadJson() throws IOException {

        List<Auto> cars = objectMapper.readValue(new File("src/main/resources/Cars.json"), new TypeReference<List<Auto>>() {
        });
        return cars;
    }

    public Auto InputToCompare(String brandmodel) throws Exception {
        //   brandmodel="Ford Focus";
        double MaxChance = 0;
        double ChancetoCoin=0;
        int indexofmax=-1;
        char[] brandsplit = brandmodel.replace(" ", "").toLowerCase().toCharArray();
        List<Auto> autos = new ArrayList<>();
        try {
            autos = ReadJson();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < autos.size(); i++) {
            String carname = autos.get(i).brand_model.replace(" ", "");
            char[] letters = carname.toLowerCase().toCharArray();
            int minlength = Math.min(letters.length, brandsplit.length);
            int counter = 0;
            if(Math.abs((brandsplit.length-letters.length))<5) {
                for (char c : brandsplit) {
                    for (char k : letters) {
                        if (c == k) {
                            counter++;
                            break;
                        }
                    }

                }

                ChancetoCoin = (double) counter / letters.length;
                if (MaxChance <= ChancetoCoin && ChancetoCoin > 0.7) {
                    MaxChance = ChancetoCoin;
                    indexofmax = i;
                }

            }
        }
        if (indexofmax < 0) {
            throw new NameNotFoundException();
        }

        return autos.get(indexofmax);

    }
}

*/