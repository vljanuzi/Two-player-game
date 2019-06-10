package javaapplication1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Car {
    
    JFrame frame;
    private String color;
    private int score;
    private String icon;
    private int fuel;
    private int player_id;
    Position position;

    public Car(int player_id) {
        color = null;
        score = 0;
        fuel = 120;
        position = new Position(1, 100);  // 1 is start poisition from bottom left;; 100 is limit of matrix maximun top left;
        this.player_id = player_id;

    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setPosition(int nextPosition) {
        //	 System.out.println(Integer.toString(nextPosition));      
        position.setPosition(nextPosition);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int fuelconsumption(String color) {

        if (color.contains("gray")) {
            if (fuel > 0) {
                fuel = fuel - (new Dice().fuel_toss());
                if (fuel < 0) {
                    fuel = 0;
                }
            }
        } else if (color.contains("green")) {
              double fuel_temp = (double)fuel;
              fuel_temp+=(fuel_temp*0.5);
              fuel = (int)fuel_temp;
             
        } else {
             position.setPosition(1);
             fuel = new Dice().randomFuel();
             return 1;
        }

        System.out.println("Color: " + color + " Fuel: " + Integer.toString(fuel));
        return 0;
    }

}
