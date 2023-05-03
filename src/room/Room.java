package room;

import booking.Booking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Room {
    /** Set containing all ID codes to ensure each is unique. */
    private static final Set<Integer> roomNumbers = new HashSet<>();
    private int roomNumber;
    private boolean lockerIsActive;

    //constructor
    public Room() {
        if (roomNumbers.isEmpty()) {
            this.roomNumber = 1;
        } else {
            this.roomNumber = roomNumbers.size() + 1;
        }
        roomNumbers.add(this.roomNumber);
        this.lockerIsActive = false;
    }

    /**
     * factory constructor to create a hotel
     * @return the created Hotel in a Arraylist<Room>
     */
    public static ArrayList<Room> createHotel() {
        final int AMOUNT_OF_SINGLE_BEDROOMS = 6;
        final int AMOUNT_OF_CONFERENCE_ROOMS = 2;
        final int AMOUNT_OF_TOILETS = 2;

        ArrayList<Room> rooms = new ArrayList<>();
        for (int j = 1; j <= AMOUNT_OF_SINGLE_BEDROOMS; j++) {
            rooms.add(new SingleBedroom());
        }
        for (int k = 1; k <= AMOUNT_OF_CONFERENCE_ROOMS; k++) {
            rooms.add(new ConferenceRoom());
        }
        for (int j = 1; j <= AMOUNT_OF_TOILETS; j++) {
            rooms.add(new Toilet());
        }
        return rooms;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean getLockerIsActive() {
        return lockerIsActive;
    }

    public void setLockerIsActive(boolean lockerIsActive) {
        this.lockerIsActive = lockerIsActive;
    }
}
