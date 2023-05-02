package gui;

import guest.Guest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Menu extends JFrame implements ActionListener {


    JButton decline, accept;
    JTextField nameText, surnameText, dateStartText, dateEndText, roomNumberText;
    Date startDate, endDate;
    JCheckBox lockerCheckBox;
    private int roomNumber;

    public Menu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(720, 500);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.GRAY);
        this.setTitle("Hotel Booking");
        this.setLocationRelativeTo(null);

        nameText = new JTextField();
        textFieldPreset(this, 50, 25, nameText,"Name");
        surnameText = new JTextField();
        textFieldPreset(this, 400, 25, surnameText,"Surname");

        dateStartText = new JTextField();
        textFieldPreset(this, 50, 100, dateStartText,"Start Date");
        dateEndText = new JTextField();
        textFieldPreset(this, 400, 100, dateEndText,"End Date");

        roomNumberText = new JTextField();
        textFieldPreset(this, 220, 175, roomNumberText,"Room Number");

        lockerCheckBox = new JCheckBox();
        checkBoxPreset(this, 220, 200, lockerCheckBox);

        decline = new JButton();
        buttonPreset(this, 50, 400, decline, "Decline");
        accept = new JButton();
        buttonPreset(this, 500, 400, accept, "Accept");

    }


    private void buttonPreset(JFrame frame, int locationX, int locationY, JButton button, String buttonName) {
        button.setSize(160, 40);
        button.setLocation(locationX, locationY);
        button.setBackground(Color.white);
        button.setText(buttonName);
        button.addActionListener(this);
        frame.add(button);
    }

    private void textFieldPreset(JFrame frame, int locationX, int locationY, JTextField textField,String function) {
        textField.setSize(new Dimension(250, 40));
        textField.setFont(new Font("Serif", Font.BOLD, 25));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.white);
        textField.setLocation(locationX, locationY);
        textField.setCaretColor(Color.BLACK);
        textField.setText(function);
        frame.add(textField);
    }

    private void checkBoxPreset(JFrame frame, int locationX, int locationY, JCheckBox checkBox) {
        checkBox.setSize(200,100);
        checkBox.setFont(new Font("Serif", Font.BOLD, 25));
        checkBox.setForeground(Color.BLACK);
        checkBox.setBackground(Color.GRAY);
        checkBox.setText("     Rent Locker");
        checkBox.setLocation(locationX, locationY);
        checkBox.setFocusable(false);
        frame.add(checkBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept) {
            Guest guest = new Guest(nameText.getText() + " " + surnameText.getText());
            startDate = setDate(dateStartText.getText());
            endDate = setDate(dateEndText.getText());
            //Booking book = new Booking(room, guest, startDate, endDate);
        }
    }

    private int roomNumb() {
        try {
            roomNumber = Integer.parseInt(roomNumberText.getText());
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return roomNumber;
    }

    private Date setDate(String dateFormat){
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat);
        } catch (ParseException e) {
        e.printStackTrace();
        }
        return date;
    }
}