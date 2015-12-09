
package se.erikperez.reservationproject.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.erikperez.reservationproject.datamanagement.DatabaseManager;
import se.erikperez.reservationproject.model.Booking;

/**
 * This class sends three different lists from database that represents the rooms already taken.
 * @see HttpServlet
 * @author Erik Perez
 * @version 1.0 
 * @since 09/12/2015
 */
@WebServlet(name="RoomSelecter", urlPatterns = {"/RoomSelecter"})
public class RoomSelecter extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Send lists from database to show the client the already taken times
        DatabaseManager databaseManager = (DatabaseManager) this.getServletContext().getAttribute("databaseManager");
        //Deletes all the old bookings from database
        int deletedValues = databaseManager.updateTable(new Date(Calendar.getInstance().getTime().getTime()));
        //Create lists to show to the client
        List<Booking> roomList1 = databaseManager.getBookingListByRoomNumber(1),
                roomList2 = databaseManager.getBookingListByRoomNumber(2),
                roomList3 = databaseManager.getBookingListByRoomNumber(3);
        
        //Shows in the log the size of the lists
        this.getServletContext().log("roomlist 1 = " + roomList1.size());
        this.getServletContext().log("roomlist 2 = " + roomList2.size());
        this.getServletContext().log("roomlist 3 = " + roomList3.size());
        //Shows in the log the values erased in the current day
        this.getServletContext().log("updated values = " + deletedValues);
        
        //creates a session
        HttpSession session = request.getSession();
        session.setAttribute("authorized", new Boolean(true));
        
        //Send the lists to the client tier
        request.setAttribute("roomlist1", roomList1);
        request.setAttribute("roomlist2", roomList2);
        request.setAttribute("roomlist3", roomList3);

        request.getRequestDispatcher("info/rooms.jsp").forward(request, response);

    }
}
