package booking;

import guest.Guest;
import room.Room;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Booking {
    /** Set containing all ID codes to ensure each is unique. */
    private static final Set<Integer> id_codes = new HashSet<>();
    private final Room room;
    private final Guest guest;
    private final Date start;
    private final Date end;
    /** Unique ID number for booking. */
    private final int id_code;

    public Booking(Room room, Guest guest, Date startOfBooking, Date endOfBooking) {
        this.room = room;
        this.guest = guest;
        this.start = startOfBooking;
        this.end = endOfBooking;
        if (id_codes.isEmpty()) {
            id_code = 1;
        } else {
            id_code = id_codes.size() + 1;
        }
        id_codes.add(id_code);
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public int getIdCode() {
        return id_code;
    }
}
