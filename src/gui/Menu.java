package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {


    public Menu() {
        this.setSize(720, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.GRAY);
        button(this, 50, 400, "decline");
        button(this, 500, 400, "accept");
        textField(this, 200, 50,"Surname");
        textField(this, 400, 50,"Forname");
    }


    private static void button(JFrame frame, int locationX, int locationY, String buttonName) {
        JButton button = new JButton();
        button.setSize(160, 40);
        button.setLocation(locationX, locationY);
        button.setBackground(Color.white);
        button.setText(buttonName);
        frame.add(button);
    }

    private static void textField(JFrame frame, int locationX, int locationY,String name) {
        JTextField textField = new JTextField();
        textField.setSize(100, 50);
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(Color.white);
        textField.setBackground(Color.white);
        textField.setLocation(locationX, locationY);
        textField.setCaretColor(Color.BLACK);
        textField.setName(name);
        frame.add(textField);
    }


}
