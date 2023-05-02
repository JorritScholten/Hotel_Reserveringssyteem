package room;

import booking.Bookable;

public class SingleBedroom extends Room implements Bookable {
    public SingleBedroom(int roomNumber){
        super(roomNumber);
    }
}
