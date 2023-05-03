package room;

import booking.AlreadyBookedException;
import booking.Bookable;
import booking.Booking;
import guest.Guest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConferenceRoom extends Room implements Bookable {
    public ConferenceRoom(int roomNumber) {
        super(roomNumber);
        bookings = new ArrayList<>();
    }

    /**
     * Create booking for room for specified guest at specified times.
     * @return Booking object for room if successful.
     * @throws AlreadyBookedException when room is already booked at specified time.
     */
    @Override
    public Booking Book(Guest guest, Date startOfBooking, Date endOfBooking)
            throws AlreadyBookedException, IllegalArgumentException {
        if (startOfBooking.after(endOfBooking)) {
            throw new IllegalArgumentException("Invalid booking: it ends before it begins.");
        }
        if (bookings.isEmpty()) {
            Booking booking = new Booking(this, guest, startOfBooking, endOfBooking);
            bookings.add(booking);
            Bookable.BOOKINGS.add(booking);
            return booking;
        } else {
            Booking previous = null, next = null;
            for (Booking b : bookings) {
                if (b.getStart().after(endOfBooking)) {
                    next = b;
                    break;
                }
            }
            for (int i = bookings.size() - 1; i >= 0; i--) {
                if (bookings.get(i).getEnd().before(startOfBooking)) {
                    previous = bookings.get(i);
                    break;
                }
            }
            if (previous == null && next == null) {
                throw new AlreadyBookedException("Booking encompasses all previous bookings.");
            } else if (previous == null) {
                // check with isBooked() to see if startOfBooking or endOfBooking is in a timeslot
                if (isBooked(startOfBooking) || isBooked(endOfBooking)) {
                    throw new AlreadyBookedException("Invalid booking: partial overlap of timeslot.");
                } else {
                    Booking booking = new Booking(this, guest, startOfBooking, endOfBooking);
                    bookings.add(0, booking);
                    Bookable.BOOKINGS.add(booking);
                    return booking;
                }
            } else if (next == null) {
                // check with isBooked() to see if startOfBooking or endOfBooking is in a timeslot
                if (isBooked(startOfBooking) || isBooked(endOfBooking)) {
                    throw new AlreadyBookedException("Invalid booking: partial overlap of timeslot.");
                } else {
                    Booking booking = new Booking(this, guest, startOfBooking, endOfBooking);
                    bookings.add(booking);
                    Bookable.BOOKINGS.add(booking);
                    return booking;
                }
            } else if (bookings.indexOf(next) + 1 == bookings.indexOf(previous)) {
                Booking booking = new Booking(this, guest, startOfBooking, endOfBooking);
                bookings.add(bookings.indexOf(previous) + 1, booking);
                Bookable.BOOKINGS.add(booking);
                return booking;
            } else {
                throw new AlreadyBookedException("Booking encompasses at least 1 previous booking.");
            }
        }
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
