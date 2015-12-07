/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.erikperez.reservationproject.infotier.DatabaseManager;
import se.erikperez.reservationproject.model.Booking;

/**
 *
 * @author Erick
 */
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
        List<Booking> roomList1 = databaseManager.getBookingListByRoomNumber(1),
                roomList2 = databaseManager.getBookingListByRoomNumber(2),
                roomList3 = databaseManager.getBookingListByRoomNumber(3);

        this.getServletContext().log("roomlist 1 = " + roomList1.size());
        this.getServletContext().log("roomlist 2 = " + roomList2.size());
        this.getServletContext().log("roomlist 3 = " + roomList3.size());

        request.setAttribute("roomlist1", roomList1);
        request.setAttribute("roomlist2", roomList2);
        request.setAttribute("roomlist3", roomList3);

        request.getRequestDispatcher("info/rooms.jsp").forward(request, response);

    }

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

    }
}
