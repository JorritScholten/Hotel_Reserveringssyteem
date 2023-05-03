package room;

public class Toilet extends Room{
    public Toilet() {
        super();
    }

    @Override
    public String toString(){
        return "Toilet, ID:" + getRoomNumber();
    }
}
