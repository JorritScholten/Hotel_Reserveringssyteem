package room;

public class ConferenceRoom extends BookableRoom {
    public ConferenceRoom() {
        super();
    }

    @Override
    public String toString(){
        return "Conference room, ID:" + getRoomNumber();
    }
}
