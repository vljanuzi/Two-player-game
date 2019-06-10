package javaapplication1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Players_Panel {

    private ArrayList<Car> cars = new ArrayList<>();
    JPanel panel = new JPanel();
    JButton player_one_car_icon = new JButton();
    JLabel player_one_name = new JLabel();
    JLabel player_one_score_title = new JLabel();
    JLabel player_one_score_value = new JLabel();
    JLabel player_one_fuel_title = new JLabel();
    JLabel player_one_fuel_value = new JLabel();
    JButton player_two_car_icon = new JButton();
    JLabel player_two_name = new JLabel();
    JLabel player_two_score_title = new JLabel();
    JLabel player_two_score_value = new JLabel();
    JLabel player_two_fuel_title = new JLabel();
    JLabel player_two_fuel_value = new JLabel();

    public Players_Panel(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public JPanel build() {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel player1 = new JPanel();
        JPanel player2 = new JPanel();

        player1.setPreferredSize(new Dimension(20, 50));

        // player_one_name.setAlignmentX(Component.CENTER_ALIGNMENT);
        player_one_name.setText("Player 1");

        player_one_car_icon.setIcon(new ImageIcon(getClass().getResource(cars.get(0).getIcon())));
        player_one_car_icon.setPreferredSize(new Dimension(100, 50));
        //player_one_car_icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        player_one_score_title.setText("Score:");

        player_one_score_value.setText(Integer.toString(cars.get(0).getScore()));

        player_one_fuel_title.setText("Fuel:");

        player_one_fuel_value.setText(Integer.toString(cars.get(0).getFuel()));

        panel.add(player_one_name);
        panel.add(player_one_car_icon);
        panel.add(player_one_score_title);
        panel.add(player_one_score_value);
        panel.add(player_one_fuel_title);
        panel.add(player_one_fuel_value);

        panel.add(player1);
    
        // player_two_name.setAlignmentX(Comptwont.CENTER_ALIGNMENT);
        player_two_name.setText("Player 2");

     
        player_two_car_icon.setIcon(new ImageIcon(getClass().getResource(cars.get(1).getIcon())));
        player_two_car_icon.setPreferredSize(new Dimension(100, 50));
        //player_two_car_icon.setAlignmentX(Comptwont.CENTER_ALIGNMENT);

      
        player_two_score_title.setText("Score:");

        
        player_two_score_value.setText(Integer.toString(cars.get(1).getScore()));

        
        player_two_fuel_title.setText("Fuel:");

       
        player_two_fuel_value.setText(Integer.toString(cars.get(1).getFuel()));

        panel.add(player_two_name);
        panel.add(player_two_car_icon);
        panel.add(player_two_score_title);
        panel.add(player_two_score_value);
        panel.add(player_two_fuel_title);
        panel.add(player_two_fuel_value);

        return panel;
    }
    
    public void update(int player_id,String type_update,int value) {
          if(player_id==1) {
              if(type_update.contains("fuel")) {
                  player_one_fuel_value.setText(Integer.toString(value));
              } else if(type_update.contains("score")) {
                  player_one_score_value.setText(Integer.toString(value));
              }
              
          } else {
               if(type_update.contains("fuel")) {
                  player_two_fuel_value.setText(Integer.toString(value));
              } else if(type_update.contains("score")) {
                  player_two_score_value.setText(Integer.toString(value));
              }
          }
    }
}
