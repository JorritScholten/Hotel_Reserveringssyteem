import guest.Guest;
import gui.Menu;
import room.Room;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {
        Room.ROOMS = Room.createHotel();
        Guest.GUESTS = Guest.createDefaultGuestList();

        JFrame menu = new Menu();
        menu.setVisible(true);
    }
}