package javaapplication1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javaapplication1.Buttons;
import javaapplication1.Players_Panel;
import javafx.beans.binding.Bindings;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Grid {

    Game game = new Game();
    Frame frame = new JFrame();
    JPanel players_side;
    static int width = 10;
    static int length = 10;
    Players_Panel players_panel;
    ArrayList<Car> cars;
    static JButton[][] grid;

    public Grid(int width, int length) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        grid = new JButton[width][length];
        int i = 1;
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1090, 600));

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(); // creates new button
                grid[x][y].setPreferredSize(new Dimension(100, 50));

                panel.add(grid[x][y]); // adds button to grid

                grid[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = ((JButton) e.getSource());

                        if (btn.getIcon() != null) {
                            cars = game.get_position();
                            ImageIcon icon = new ImageIcon(getClass().getResource(cars.get(0).getIcon()));
                            File f = new File(((ImageIcon) btn.getIcon()).getDescription().replace("file:/", ""));

                            if (f.getName().contains(cars.get(0).getIcon().replace("/resource/", "")) || cars.get(0).getPosition() == cars.get(1).getPosition()) {

                                if (cars.get(0).getPosition() == cars.get(1).getPosition()) {
                                    cars = game.move();
                                    movePosition();                                    
                                    icon = resizeIcon(new ImageIcon(getClass().getResource(cars.get(1).getIcon())), 98, 50);
                                    PreviousPosition(0);

                                } else {
                                    cars = game.move();
                                    movePosition();

                                    String[] data = btn.getActionCommand().split(",");

                                    btn.setIcon(null);
                                    PreviousPosition(Integer.parseInt(data[0]));
                                }

                            } else {
                                JOptionPane.showMessageDialog(frame, "Opponent turn.");
                            }
                            cars = game.get_position();
                            
                            if(cars.get(0).getPosition()>=100 ||cars.get(0).getPosition()>=100) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int winner_index=0;
                            
                            if(cars.get(0).getPosition()>=100) winner_index=0; else  winner_index=1;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Winner is Player "+cars.get(winner_index).getPlayer_id()+"\n\nClick Yes for new game", "Info", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {                                    
                                new Grid(10,10);
                                frame.dispose();

                            } else {
                                System.exit(0);
                            }
                           }
                        }
                    }

                });
            }
        }
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();

        container.add(panel);

        players_panel = new Players_Panel(game.get_position());
        players_side = players_panel.build();
        container.add(players_side);
        frame.add(container);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(10, 100);
        frame.pack();

        int type = 0;

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 && y == length - 1) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/resource/download3.jpg"));
                    grid[x][y].setIcon(icon);
                }
                grid[x][y].setBackground(Color.GRAY);

            }

        }
        for (int y = length - 1; y >= 0; y--) {
            if (type == 0) {
                for (int x = 0; x < width; x++) {
                    String color = "";

                    if (grid[x][y].getBackground() == Color.gray) {
                        color = "gray";
                    } else if (grid[x][y].getBackground() == Color.green) {
                        color = "green";
                    } else {
                        color = "black";
                    }
                    grid[x][y].setActionCommand(Integer.toString(i) + "," + color);
                    i++;
                }
            } else {
                for (int x = width - 1; x >= 0; x--) {
                    String color = "";
                    if (grid[x][y].getBackground() == Color.gray) {
                        color = "gray";
                    } else if (grid[x][y].getBackground() == Color.green) {
                        color = "green";
                    } else {
                        color = "black";
                    }
                    grid[x][y].setActionCommand(Integer.toString(i) + "," + color);
                    i++;
                }
            }
            if (type == 0) {
                type = 1;
            } else {
                type = 0;
            }
        }
        setRandom();
        cars = game.getCars();
    }

    public static void main(String[] args) {
        new Grid(width, length);
    }

    private static void setRandom() {

        for (int i = 0; i < 10; i++) {
            int type = 1 + (int) (80 * Math.random());
            for (int y = 0; y < length; y++) {
                for (int x = 0; x < width; x++) {

                    if (Integer.parseInt(grid[x][y].getActionCommand().split(",")[0]) == type) {
                        grid[x][y].setBackground(Color.green);
                        grid[x][y].setActionCommand(grid[x][y].getActionCommand().split(",")[0] + ",green");

                    }
                }
            }
        }

        for (int i = 0; i < 40; i++) {
            int type = 1 + (int) (80 * Math.random());
            for (int y = 0; y < length; y++) {
                for (int x = 0; x < width; x++) {

                    if (Integer.parseInt(grid[x][y].getActionCommand().split(",")[0]) == type) {
                        grid[x][y].setBackground(Color.black);
                        grid[x][y].setActionCommand(grid[x][y].getActionCommand().split(",")[0] + ",black");
                    }
                }
            }
        }
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void movePosition() {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                if (Integer.parseInt(grid[x][y].getActionCommand().split(",")[0]) == cars.get(0).getPosition()) {
                    ImageIcon icon;
                    if (cars.get(0).getPosition() == cars.get(1).getPosition()) {
                        icon = new ImageIcon(getClass().getResource("/resource/download3.jpg"));
                    } else {
                        icon = new ImageIcon(getClass().getResource(cars.get(0).getIcon()));
                    }
                    grid[x][y].setIcon(icon);
                    break;
                }
            }
        }
    }

    private void PreviousPosition(int i) {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                if (Integer.parseInt(grid[x][y].getActionCommand().split(",")[0]) == cars.get(1).getPosition()) {
                    String[] data = grid[x][y].getActionCommand().split(",");
                    int fuelMode = cars.get(1).fuelconsumption(data[1]);

                    cars = game.get_position();

                    if (fuelMode == 1) {
                         cars = game.get_position();
                         cars =   game.resetPlayerPosition();
                         
                          grid[x][y].setIcon(null);                        
                           grid[0][length-1].setIcon(new ImageIcon(getClass().getResource(cars.get(0).getIcon())));
                           
                    } else {
                        ImageIcon icon;
                        if (cars.get(0).getPosition() == cars.get(1).getPosition()) {
                            icon = new ImageIcon(getClass().getResource("/resource/download3.jpg"));
                        } else {
                            icon = new ImageIcon(getClass().getResource(cars.get(1).getIcon()));
                        }

                        grid[x][y].setIcon(icon);
                    }

                    players_panel.update(cars.get(1).getPlayer_id(), "fuel", cars.get(1).getFuel());
                    // break;
                }

                if (Integer.parseInt(grid[x][y].getActionCommand().split(",")[0]) == i) {
                    String[] data = grid[x][y].getActionCommand().split(",");
                    if (data[1].contains("gray")) {
                        grid[x][y].setBackground(Color.gray);
                    } else if (data[1].contains("green")) {
                        grid[x][y].setBackground(Color.green);
                    } else {
                        grid[x][y].setBackground(Color.black);
                    }
                }
            }
        }
    }

}
