package room;

import booking.Bookable;

public class ConferenceRoom extends Room implements Bookable{
    public ConferenceRoom(int roomNumber) {
        super(roomNumber);
    }
}
