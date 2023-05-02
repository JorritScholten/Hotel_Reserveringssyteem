package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    static JButton button;
    static JFrame mainFrame;
    static JTextField textField;



    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu() {
        mainFrame();
        button(mainFrame,50,400,"decline");
        button(mainFrame,500,400,"accept");
        textFieldSurname(mainFrame,50,250);

    }

    private static void mainFrame(){
        mainFrame = new JFrame();
        mainFrame.setSize(720, 500);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setBackground(Color.GRAY);
    }

    private static void button(JFrame frame,int locationX,int locationY,String buttonName ){
        button = new JButton();
        ActionListener MouseListener = button.getAction();
        button.setSize(160,40);
        button.setLocation(locationX,locationY);
        button.setBackground(Color.white);
        button.setText(buttonName);
        button.addActionListener(MouseListener);
        button.setVisible(true);
        frame.add(button);
    }

    private static void textFieldSurname(JFrame frame, int locationX, int locationY){
        textField = new JTextField();
        textField.setSize(160,40);
        textField.setLocation(locationX,locationY);
        textField.setBackground(Color.white);
        textField.setText("Surname");
        textField.setVisible(true);
        frame.add(textField);
    }

    private void buttonClicked(ActionEvent e) {
        if (e.getSource() == button) {

        }
    }

}
