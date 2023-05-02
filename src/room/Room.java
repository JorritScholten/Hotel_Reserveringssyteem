package room;

import booking.Booking;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private int roomNumber;
    private boolean lockerIsActive;
    protected List<Booking> bookings;

    //constructor
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.lockerIsActive = false;
    }

    /**
     * factory constructor to create a hotel
     * @return the created Hotel in a Arraylist<Room>
     */
    public static ArrayList<Room> createHotel() {
        final int AMOUNT_OF_ROOMS = 10;
        final int AMOUNT_OF_SINGLE_BEDROOMS = 6;
        final int AMOUNT_OF_CONFERENCE_ROOMS = 2;
        final int AMOUNT_OF_TOILETS = 2;

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= AMOUNT_OF_ROOMS; i++) {
            for (int j = 1; j <= AMOUNT_OF_SINGLE_BEDROOMS; j++) {
                rooms.add(new SingleBedroom(i));
            }
            for (int k = 1; k <= AMOUNT_OF_CONFERENCE_ROOMS; k++) {
                rooms.add(new ConferenceRoom(i));
            }
            for (int j = 1; j <= AMOUNT_OF_TOILETS; j++) {
                rooms.add(new Toilet(i));
            }
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
