
package se.erikperez.reservationproject.datamanagement;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import se.erikperez.reservationproject.model.Booking;

/**
 * This class generates a database connection and manages all the transactions
 * @author Erik Perez
 * @version 1.0
 * @since 09/12/2015
 */
public final class DatabaseManager {

    private static final String PERSISTENCE_UNIT_NAME = "reservationproject";
    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static final String ALLOWED_CHARACTERS = "^[A-Za-z0-9]+$",
            ALLOWED_CHARACTERS_EMAIL = "^[A-Za-z0-9\\.@]+$";

    public DatabaseManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    /**
     * This method verifies if the string that comes from the request is allowed to be stored in the database
     * @param requestString the string to be verified
     * @param email true if the string is a mail, false otherwise
     * @return true if the string is allowed to be stored in the database, false otherwise
     */
     private boolean isStringAllowed(String requestString, boolean email){
        if(email){
            if(!requestString.matches(ALLOWED_CHARACTERS_EMAIL)){
                return false;
            }
        }else{
            if(!requestString.matches(ALLOWED_CHARACTERS)){
                return false;
            }
        }
        return true;
    }
     /**
      *This method makes a list of objects from the database that have a room number in common,
      *is used to show a list of the bookings already taken to the client 
      *@param roomnumber the number in common between the objects
      *@return a list of Booking objects from database
      */
    public List<Booking> getBookingListByRoomNumber(int roomnumber) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.
                    createNamedQuery("booking.findAllbyRoom").
                    setParameter("roomNumber", roomnumber).
                    getResultList();
        } finally {
            entityManager.close();
        }

    }
    /**
     * This method erases all the objects from database that are older than the current date
     * @param today the current day
     * @return a number of objects erased from database
     */
    public int updateTable(Date today) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            return entityManager.createNamedQuery("booking.updateTable").
                    setParameter("today", today).executeUpdate();
        } finally {
            entityManager.close();
        }

    }
    /**
     * This method manages the transaction to add a new object to database
     * @param firstname the first name of the client to be added to the entity object
     * @param lastname the last name of the client to be added to the entity object
     * @param email the email of the client to be added to the entity object
     * @param roomNumber the number of the room to be added to the entity object
     * @param bookingDate the date of the booking to be added to the entity object
     * @param startTime the start time of the booking to be added to the entity object
     * @param endTime the end time of the booking to be added to the entity object
     * @return a new Booking object
     */
    private Booking newBooking(String firstname, String lastname, String email, int roomNumber, Date bookingDate, String startTime, String endTime) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Booking newBooking = new Booking(firstname, lastname, email, roomNumber, bookingDate, startTime, endTime);
            entityManager.persist(newBooking);
            entityManager.getTransaction().commit();
            return newBooking;
        } finally {
            entityManager.close();
        }
    }
    /**
     * This method verifies first if the parameters are allowed to be stored to the database, if they are, then it verifies if the time to be booked 
     * is able to book, if it is so, then the transaction to store the object to the database begins.
     * @param firstname the first name of the client to be added to the entity object
     * @param lastname the last name of the client to be added to the entity object
     * @param email the email of the client to be added to the entity object
     * @param roomNumber the number of the room to be added to the entity object
     * @param bookingDate the date of the booking to be added to the entity object
     * @param startTime the start time of the booking to be added to the entity object
     * @param endTime the end time of the booking to be added to the entity object
     * @return a new Booking object if the parameters are allowed to be stored and if the date to be stored is not taken yet, null otherwise
     */
    public Booking addBooking(String firstname, String lastname, String email, int roomNumber, Date bookingDate, String startTime, String endTime){
        if(!isStringAllowed(firstname,false) ||!isStringAllowed(lastname,false) ||!isStringAllowed(email,true)){
            return null;
        }
        Booking newBooking = (isBookingNotAble(roomNumber, bookingDate, startTime, endTime)
                ? null
                : newBooking(firstname, lastname, email, roomNumber, bookingDate, startTime, endTime));
        return newBooking;
    }
    /**
     * This method verifies if the date and the moment to be booked is able to book
     * @param roomNumber the room of the booking
     * @param bookingDate the date of the booking
     * @param startTime the time to start of the booking
     * @param endTime the time to end of the booking
     * @return true if the booking is not able to book, false otherwise
     */
    private boolean isBookingNotAble(int roomNumber, Date bookingDate, String startTime, String endTime) {

        List<Booking> bookingList = this.getBookingListByRoomNumber(roomNumber);
        if (bookingList.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < bookingList.size(); i++) {
                if (bookingList.get(i).getBookingDate().toString().equals(bookingDate.toString())
                        && bookingList.get(i).getStartTime().equals(startTime)
                        && bookingList.get(i).getEndTime().equals(endTime)) {
                    return true;
                }
            }
        }

        return false;
    }

}
