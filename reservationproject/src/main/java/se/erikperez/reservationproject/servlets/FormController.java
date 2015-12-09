package se.erikperez.reservationproject.servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.erikperez.reservationproject.datamanagement.DatabaseManager;
import se.erikperez.reservationproject.model.Booking;

/**
 * This class manages the request that comes from the forms done in the site
 * to book a room to play
 * @see HttpServlet
 * @author Erik Perez
 * @version 1.0
 * @since 09/12/2015
 */
@WebServlet(name = "FormController", urlPatterns = {"/FormController"})
public class FormController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boolean that evaluates which response the client will have
        boolean succeed = true;
         //The requests from the client
        int roomNumber = Integer.parseInt(request.getParameter("roomnumber"));
        String firstname = request.getParameter("firstname"),
                lastname = request.getParameter("lastname"),
                email = request.getParameter("email");
        Date date = Date.valueOf(request.getParameter("date"));

        String[] moment = request.getParameter("select").split("-");
        String startTime = moment[0],
                endTime = moment[1];
        
        //Database handling
        DatabaseManager databaseManager = (DatabaseManager) this.getServletContext().getAttribute("databaseManager");
        Booking newBooking = databaseManager.addBooking(firstname, lastname, email, roomNumber, date, startTime, endTime);

        if (newBooking == null) {
            succeed = false;
        }

        request.setAttribute("succeed", succeed);
        
        //Managing the session of the client
        HttpSession session = request.getSession();
        boolean authorized = (boolean) session.getAttribute("authorized");

        if (authorized) {
            authorized = false;
        }
        //invalidate after the request is evaluated
        session.invalidate();

        if (succeed) {
            //if the booking successfully handles and stores in database
            request.setAttribute("roomnumber", roomNumber);
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("email", email);
            request.setAttribute("date", date.toString());
            request.setAttribute("from", startTime);
            request.setAttribute("to", endTime);
            request.getRequestDispatcher("confirmation/result.jsp").forward(request, response);
        } else {
            //if the booking fails
            request.setAttribute("error", "You Request is not valid, please try again!");
            request.getRequestDispatcher("confirmation/result.jsp").forward(request, response);
        }

    }

}
