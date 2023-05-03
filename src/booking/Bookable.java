package booking;

import guest.Guest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Bookable {
    List<Booking> BOOKINGS = new ArrayList<>();

    /**
     * Create booking for room for specified guest at specified times.
     * @return Booking object for room if successful.
     * @throws AlreadyBookedException when room is already booked at specified time.
     */
    Booking Book(Guest guest, Date startOfBooking, Date endOfBooking, boolean rentLocker) throws AlreadyBookedException;

    /**
     * Get list of bookings this room has.
     * @return List of bookings for room, null if room has no bookings.
     */
    List<Booking> getBookings();

    /**
     * Check if room is currently booked.
     * @param now time to check room at.
     * @return true if room is booked during now.
     */
    boolean isBooked(Date now);
}
