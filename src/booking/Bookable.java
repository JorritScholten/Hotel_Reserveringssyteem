package booking;

import guest.Guest;

import java.util.Date;
import java.util.List;

public interface Bookable {
    /**
     * Create booking for room for specified guest at specified times.
     * @return Booking object for room if successful.
     * @throws AlreadyBookedException when room is already booked at specified time.
     */
    Booking Book(Guest guest, Date startOfBooking, Date endOfBooking) throws AlreadyBookedException;

    /**
     * Get list of bookings this room has.
     * @return List of bookings for room, null if room has no bookings.
     */
    List<Booking> getBookings();
}
