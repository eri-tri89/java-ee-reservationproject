/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.infotier;

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
public final class DatabaseManager{

    private final String PERSISTENCE_UNIT_NAME = "reservationproject";
    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DatabaseManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
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

    public Booking addBooking(String firstname, String lastname, String email, int roomNumber, Date bookingDate, String startTime, String endTime) throws NullPointerException {
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
            for(int i = 0; i < bookingList.size(); i++){
                if (bookingList.get(i).getBookingDate().toString().equals(bookingDate.toString()) &&
                        bookingList.get(i).getStartTime().equals(startTime)
                        && bookingList.get(i).getEndTime().equals(endTime)) {
                    return true;
                }
            }
            /*for (Booking booking : bookingList) {
                if (booking.getBookingDate().equals(bookingDate) && booking.getStartTime().equals(startTime)
                        && booking.getEndTime().equals(endTime)) {
                    return true;
                }
            }*/
        }

        return false;
    }

}
