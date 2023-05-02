package room;

import booking.AlreadyBookedException;
import booking.Bookable;
import booking.Booking;
import guest.Guest;

import java.util.Date;
import java.util.List;

public class ConferenceRoom extends Room implements Bookable {
    public ConferenceRoom(int roomNumber) {
        super(roomNumber);
    }

    /**
     * Create booking for room for specified guest at specified times.
     * @return Booking object for room if successful.
     * @throws AlreadyBookedException when room is already booked at specified time.
     */
    @Override
    public Booking Book(Guest guest, Date startOfBooking, Date endOfBooking) throws AlreadyBookedException {

    }

    /**
     * Get list of bookings this room has.
     * @return List of bookings for room, null if room has no bookings.
     */
    @Override
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Check if room is currently booked.
     * @param now time to check room at.
     * @return true if room is booked during now.
     */
    @Override
    public boolean isBooked(Date now) {
        for (Booking b : bookings) {
            if (b.getStart().before(now) && b.getEnd().after(now)) {
                return true;
            }
        }
        return false;
    }
}
