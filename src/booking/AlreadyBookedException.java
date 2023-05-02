package booking;

/**
 * Exception thrown when trying to book a room whilst it's already booked.
 */
public class AlreadyBookedException extends Exception {
    public AlreadyBookedException(String errorMessage) {
        super(errorMessage);
    }
}
