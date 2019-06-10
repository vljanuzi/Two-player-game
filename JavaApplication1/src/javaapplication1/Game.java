package javaapplication1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Game {

    private Car PlayerTurn;
    private Car PlayerNextTurn;
    private String[] icons = new String[]{"/resource/download1.jpg", "/resource/download2.jpg"};
    private ArrayList<Car> cars = new ArrayList<>();

    public Car getPlayerTurn() {
        return PlayerTurn;
    }

    public Car getPlayerNextTurn() {
        return PlayerNextTurn;
    }
    private Dice dice;
    int turn = 0;

    public Game() {
        startNewGame();
    }

    void startNewGame() {
        /*String p1Name;
		String p2Name;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter player one name: ");
		p1Name = sc.nextLine();
		System.out.print("Please enter player two name: ");
		p2Name = sc.nextLine();*/

        dice = new Dice();

        int firstIcon = (int) (this.icons.length * Math.random());
        int secondIcon = 0;
        if (firstIcon == 0) {
            secondIcon = 1;
        }
        for (int i = 0; i < 2; i++) {
            Car temp_car = new Car(i + 1);
            if (i == 0) {
                temp_car.setIcon(this.icons[firstIcon]);
            } else {
                temp_car.setIcon(this.icons[secondIcon]);
            }
            cars.add(temp_car);

        }
        for (Car temp_car : cars) {
            System.out.println(temp_car.getIcon() + "\n\n");
        }

    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Car> move() {

        ArrayList<Car> temp_list = new ArrayList<>();
        if (turn == 0) {
            cars.get(0).setPosition(dice.toss());
            temp_list.add(cars.get(1));
            temp_list.add(cars.get(0));

            turn = 1;
        } else {
            turn = 0;
            cars.get(1).setPosition(dice.toss());
            // cars.get(1).fuelconsumption(color);
            temp_list.add(cars.get(0));
            temp_list.add(cars.get(1));
        }
        if(cars.get(0).getPosition()>=100) {
           int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){
  // Saving code here
}
        }
        return temp_list;

    }

    public ArrayList<Car> get_position() {

        ArrayList<Car> temp_list = new ArrayList<>();
        if (turn == 0) {
            temp_list.add(cars.get(0));
            temp_list.add(cars.get(1));
        } else {
            temp_list.add(cars.get(1));
            temp_list.add(cars.get(0));
        }
        return temp_list;
    }

    public  ArrayList<Car> resetPlayerPosition() {

        if (turn == 0) {          
            cars.get(0).setPosition(1);
        } else {
          //  System.out.println("Mode 1");
            cars.get(1).setPosition(1);
        }
        
        return get_position();

    }

}
