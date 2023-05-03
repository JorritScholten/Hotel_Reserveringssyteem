package gui;

import guest.Guest;
import room.BookableRoom;
import room.Room;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu extends JFrame implements ActionListener {
    JButton accept, guestListButton;
    JTextField nameText, surnameText, dateStartText, dateEndText, roomNumberText;
    JCheckBox lockerCheckBox;

    public Menu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(720, 640);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.GRAY);
        this.setTitle("Hotel Reservations");
        this.setLocationRelativeTo(null);

        guiDesignLoader();
    }

    private void guiDesignLoader() {
        nameText = new JTextField();
        textFieldPreset( 50, 350, nameText, "First Name");
        surnameText = new JTextField();
        textFieldPreset( 400, 350, surnameText, "Surname");

        dateStartText = new JTextField();
        textFieldPreset( 50, 400, dateStartText, "Start Date");
        dateEndText = new JTextField();
        textFieldPreset( 400, 400, dateEndText, "End Date");

        roomNumberText = new JTextField();
        textFieldPreset( 50, 450, roomNumberText, "Room Number");

        lockerCheckBox = new JCheckBox();
        checkBoxPreset( 400, 450, lockerCheckBox);

        accept = new JButton();
        buttonPreset( 500, 525, accept, "Accept");
        guestListButton = new JButton();
        buttonPreset( 50, 525, guestListButton, "Guest List");

        jPanelPreset( 50, 40);
        feedBackPanel( 75, 65, "");
    }

    private void buttonPreset(int locationX, int locationY, JButton button, String buttonName) {
        button.setSize(160, 40);
        button.setLocation(locationX, locationY);
        button.setBackground(Color.white);
        button.setText(buttonName);
        button.addActionListener(this);
        this.add(button);
    }

    private void textFieldPreset(int locationX, int locationY, JTextField textField, String function) {
        textField.setSize(new Dimension(250, 40));
        textField.setFont(new Font("Serif", Font.BOLD, 25));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.white);
        textField.setLocation(locationX, locationY);
        textField.setCaretColor(Color.BLACK);
        textField.setText(function);
        this.add(textField);
    }

    private void checkBoxPreset(int locationX, int locationY, JCheckBox checkBox) {
        checkBox.setSize(new Dimension(250, 40));
        checkBox.setFont(new Font("Serif", Font.BOLD, 25));
        checkBox.setForeground(Color.BLACK);
        checkBox.setBackground(Color.white);
        checkBox.setText("Rent Locker");
        checkBox.setLocation(locationX, locationY);
        checkBox.setFocusable(false);
        this.add(checkBox);
    }

    private void feedBackPanel(int locationX, int locationY, String paneText) {
        JTextPane feedBackPanel = new JTextPane();
        feedBackPanel.setLocation(locationX, locationY);
        feedBackPanel.setSize(550, 250);
        feedBackPanel.setBackground(Color.white);
        feedBackPanel.setFont(new Font("Serif", Font.BOLD, 20));
        feedBackPanel.setEditable(false);
        feedBackPanel.setText(paneText);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        feedBackPanel.setBorder(BorderFactory.createCompoundBorder(
                border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        this.add(feedBackPanel);
    }

    private void jPanelPreset(int locationX, int locationY) {
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLocation(locationX, locationY);
        feedbackPanel.setSize(600, 300);
        feedbackPanel.setBackground(Color.white);
        this.add(feedbackPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept) {
            Guest guest = new Guest(nameText.getText() + " " + surnameText.getText());
            if (roomNumb() != Integer.MIN_VALUE) {
                if (Room.ROOMS.get(roomNumb()) instanceof BookableRoom) {
                    try {
                        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateStartText.getText());
                        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateEndText.getText());
                        ((BookableRoom) Room.ROOMS.get(roomNumb())).Book(guest, startDate, endDate, lockerCheckBox.isSelected());
                        Guest.GUESTS.add(guest);

                        feedBackPanel( 75, 65, "Booking successful:\n" +
                                nameText.getText() + " " + surnameText.getText() + "\n" +
                                startDate + "\n" +
                                endDate + "\n" +
                                "Renting a locker: " + lockerCheckBox.isSelected()
                        );
                    } catch (Exception ex) {
                        feedBackPanel( 75, 65, ex.getMessage());
                    }
                }
            } else {
                feedBackPanel( 75, 65, "Trying to book un-bookable room.");
            }
        }

        if (e.getSource() == guestListButton) {
            String guestList = "";
            for (Guest g : Guest.GUESTS) {
                guestList += g.getName() + "\n";
            }
            feedBackPanel( 75, 65, guestList);
        }
    }

    private int roomNumb() {
        int roomNumber = Integer.MIN_VALUE;
        try {
            roomNumber = Integer.parseInt(roomNumberText.getText());
        } catch (Exception ex) {
            feedBackPanel(75, 65, "Malformed input: " + ex.getMessage());
        }
        return roomNumber;
    }
}