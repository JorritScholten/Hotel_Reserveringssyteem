package room;

public class SingleBedroom extends BookableRoom {
    public SingleBedroom() {
        super();
    }

    @Override
    public String toString(){
        return "Single bedroom, ID:" + getRoomNumber();
    }
}
