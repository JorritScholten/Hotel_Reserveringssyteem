package gui;

import guest.Guest;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Menu extends JFrame implements ActionListener {


    JButton decline, accept, guestListButton;
    JTextField nameText, surnameText, dateStartText, dateEndText, roomNumberText;
    Date startDate, endDate;
    JCheckBox lockerCheckBox;
    JTextPane feedBackPanel;


    private int roomNumber;
    private String feedBackString;

    public Menu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(720, 640);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.GRAY);
        this.setTitle("Hotel Booking");
        this.setLocationRelativeTo(null);

        guiDesignLoader();


    }

    private void guiDesignLoader() {

        nameText = new JTextField();
        textFieldPreset(this, 50, 350, nameText, "Name");
        surnameText = new JTextField();
        textFieldPreset(this, 400, 350, surnameText, "Surname");

        dateStartText = new JTextField();
        textFieldPreset(this, 50, 400, dateStartText, "Start Date");
        dateEndText = new JTextField();
        textFieldPreset(this, 400, 400, dateEndText, "End Date");

        roomNumberText = new JTextField();
        textFieldPreset(this, 50, 450, roomNumberText, "Room Number");

        lockerCheckBox = new JCheckBox();
        checkBoxPreset(this, 400, 450, lockerCheckBox);

        decline = new JButton();
        buttonPreset(this, 50, 525, decline, "Decline");
        accept = new JButton();
        buttonPreset(this, 500, 525, accept, "Accept");
        guestListButton = new JButton();
        buttonPreset(this, 275, 525, guestListButton, "Guest List");


        jPanelPreset(this, 50, 40);
        feedBackPanel(this, 75, 65, feedBackString);
    }

    private void buttonPreset(JFrame frame, int locationX, int locationY, JButton button, String buttonName) {
        button.setSize(160, 40);
        button.setLocation(locationX, locationY);
        button.setBackground(Color.white);
        button.setText(buttonName);
        button.addActionListener(this);
        frame.add(button);
    }

    private void textFieldPreset(JFrame frame, int locationX, int locationY, JTextField textField, String function) {
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
        checkBox.setSize(new Dimension(250, 40));
        checkBox.setFont(new Font("Serif", Font.BOLD, 25));
        checkBox.setForeground(Color.BLACK);
        checkBox.setBackground(Color.white);
        checkBox.setText("     Rent Locker");
        checkBox.setLocation(locationX, locationY);
        checkBox.setFocusable(false);
        frame.add(checkBox);
    }

    private void feedBackPanel(JFrame frame, int locationX, int locationY, String paneText) {
        JTextPane feedBackPanel = new JTextPane();
        feedBackPanel.setLocation(locationX, locationY);
        feedBackPanel.setSize(550, 250);
        feedBackPanel.setBackground(Color.white);
        feedBackPanel.setEditable(false);
        feedBackPanel.setText(paneText);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        feedBackPanel.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        frame.add(feedBackPanel);

    }


    private void jPanelPreset(JFrame frame, int locationX, int locationY) {
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLocation(locationX, locationY);
        feedbackPanel.setSize(600, 300);
        feedbackPanel.setBackground(Color.white);
        System.out.println(feedBackString);
        frame.add(feedbackPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept) {
            Guest guest = new Guest(nameText.getText() + " " + surnameText.getText());
            startDate = setDate(dateStartText.getText());
            endDate = setDate(dateEndText.getText());

            System.out.println(nameText.getText() + " " + surnameText.getText());
            System.out.println(startDate);
            System.out.println(endDate);
            System.out.println(lockerCheckBox.isSelected());
            //Booking book = new Booking(room, guest, startDate, endDate);
        }
        if (e.getSource() == decline) {
        }

        if (e.getSource() == guestListButton) {
            feedBackPanel(this, 75, 65, feedBackString);
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

    private Date setDate(String dateFormat) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}