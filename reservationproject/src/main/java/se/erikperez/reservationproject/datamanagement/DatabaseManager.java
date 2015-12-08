/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.datamanagement;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import se.erikperez.reservationproject.model.Booking;

/**
 *
 * @author Erick
 */
public final class DatabaseManager {

    private final String PERSISTENCE_UNIT_NAME = "reservationproject";
    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static final String ALLOWED_CHARACTERS = "^[A-Za-z0-9]+$",
            ALLOWED_CHARACTERS_EMAIL = "^[A-Za-z0-9\\.@]+$";

    public DatabaseManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    
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

    public int updateTable(Date today) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            return entityManager.createNamedQuery("booking.updateTable").
                    setParameter("bookingDate", today).executeUpdate();
        } finally {
            entityManager.close();
        }

    }

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

    public Booking addBooking(String firstname, String lastname, String email, int roomNumber, Date bookingDate, String startTime, String endTime){
        if(!isStringAllowed(firstname,false) ||!isStringAllowed(lastname,false) ||!isStringAllowed(email,true)){
            return null;
        }
        Booking newBooking = (isBookingNotAble(roomNumber, bookingDate, startTime, endTime)
                ? null
                : newBooking(firstname, lastname, email, roomNumber, bookingDate, startTime, endTime));
        return newBooking;
    }

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
