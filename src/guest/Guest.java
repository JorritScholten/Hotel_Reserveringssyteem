package guest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Guest {
    private String name;
    private Date startOfBooking;
    private Date endOfBooking;

    public Guest(String name, Date startOfBooking, Date endOfBooking) {
        this.name = name;
        this.startOfBooking = startOfBooking;
        this.endOfBooking = endOfBooking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartOfBooking(Date startOfBooking) {
        this.startOfBooking = startOfBooking;
    }

    public void setEndOfBooking(Date endOfBooking) {
        this.endOfBooking = endOfBooking;
    }

    public static Guest createKees() {
        return new Guest("Kees", '');
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