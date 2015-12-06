/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.erikperez.reservationproject.dataManagement.DatabaseManager;
import se.erikperez.reservationproject.dataManagement.RequestStringManager;

/**
 *
 * @author Erick
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
        int roomNumber = Integer.parseInt(request.getParameter("roomnumber"));
        String firstname = request.getParameter("firstname"),
                lastname = request.getParameter("lastname"),
                email = request.getParameter("email");
        Date date = RequestStringManager.parseToSQLDate(request.getParameter("date"));

        String[] moment = request.getParameter("select").split("-");
        String startTime = moment[0],
                endTime = moment[1];

        //verify request values
        RequestStringManager.manageInvalidRequest(request, response, firstname, RequestStringManager.isStringAllowed(firstname, false));
        RequestStringManager.manageInvalidRequest(request, response, firstname, RequestStringManager.isStringAllowed(lastname, false));
        RequestStringManager.manageInvalidRequest(request, response, firstname, RequestStringManager.isStringAllowed(email, true));
        
        
        try (DatabaseManager databaseManager = (DatabaseManager) this.getServletContext().getAttribute("databaseManager")) {
            databaseManager.addBooking(firstname, lastname, email, roomNumber, date, startTime, endTime);
        } catch (Exception ex) { 
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("roomnumber", roomNumber);
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("email", email);
        request.setAttribute("date", date.toString());
        request.setAttribute("from", startTime);
        request.setAttribute("to", endTime);

        request.getRequestDispatcher("confirmation/thanks.jsp").forward(request, response);

    }

}
