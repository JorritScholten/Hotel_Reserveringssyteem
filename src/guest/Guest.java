package guest;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    final private String name;

    public Guest(String name) {
        this.name = name;
    }

    public static List<Guest> createDefaultGuestList() {
        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest("Kees"));
        guests.add(new Guest("William"));
        guests.add(new Guest("Arthur"));
        guests.add(new Guest("Henry"));
        return guests;
    }
}