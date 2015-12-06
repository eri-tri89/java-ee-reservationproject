/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.dataManagement;


import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import se.erikperez.reservationproject.model.Booking;

/**
 *
 * @author Erick
 */
public final class DatabaseManager implements AutoCloseable {

    private final String PERSISTENCE_UNIT_NAME = "reservationproject";
    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DatabaseManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    
    public boolean isEntityManagerOpen(){
        return entityManager.isOpen();
    }

    public List<Booking> getBookingListByRoomNumber(int roomnumber) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.
                createNamedQuery("booking.findAllbyRoom").
                setParameter("roomNumber", roomnumber).
                getResultList();

    }
    
    public int updateTable(Date today){
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createNamedQuery("booking.updateTable").setParameter("bookingDate", today).executeUpdate();
    }

    private Booking newBooking(String firstname, String lastname, String email, int roomNumber, Date bookingDate, String startTime, String endTime) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Booking newBooking = new Booking(firstname, lastname, email, roomNumber, bookingDate, startTime, endTime);
        entityManager.persist(newBooking);
        entityManager.getTransaction().commit();
        return newBooking;
    }

    
    public Booking addBooking(String firstname, String lastname, String email, int roomNumber, Date bookingDate, String startTime, String endTime) throws NullPointerException {
        Booking newBooking = (isBookingNotAble(roomNumber, bookingDate, startTime, endTime)
                ? null
                : newBooking(firstname, lastname, email, roomNumber, bookingDate, startTime, endTime));
        return newBooking;
    }

    private boolean isBookingNotAble(int roomNumber, Date bookingDate, String startTime, String endTime) {
        entityManager = entityManagerFactory.createEntityManager();
        Booking bookingByRoomNumber = entityManager.find(Booking.class, roomNumber);//something is null here! verify!
        if(bookingByRoomNumber != null){
             return (bookingByRoomNumber.getBookingDate().equals(bookingDate))?
                (bookingByRoomNumber.getStartTime().equals(startTime) && bookingByRoomNumber.getEndTime().equals(endTime)):
                false;
        }else{
            return false;
        }
       
    }

    @Override
    public void close() throws Exception {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
            entityManager = null;
        } else {
            throw new UnsupportedOperationException("entityManager already null"); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
