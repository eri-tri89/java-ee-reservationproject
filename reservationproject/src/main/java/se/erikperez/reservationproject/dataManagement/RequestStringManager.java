/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.dataManagement;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick
 */
public final class RequestStringManager {
    
    private static final String ALLOWED_CHARACTERS = "^[A-Za-z0-9]+$", 
            ALLOWED_CHARACTERS_EMAIL = "^[A-Za-z0-9\\.@]+$";
        
    public static Date parseToSQLDate(String date){
        return Date.valueOf(date);
    }
    
    public static boolean isStringAllowed(String requestString, boolean email){
        return (email)?
                requestString.contains(ALLOWED_CHARACTERS_EMAIL):
                requestString.contains(ALLOWED_CHARACTERS);
    }
    
    public static void manageInvalidRequest(HttpServletRequest request, HttpServletResponse response, String requestString, boolean isStringAllowed) 
            throws ServletException, IOException{
        request.setAttribute("notAllowedMessage", "Your request is not allowed, please try again");
        RequestDispatcher requestDispatcher = (isStringAllowed)? request.getRequestDispatcher("info/rooms.jsp"):null;
        if(requestDispatcher != null)requestDispatcher.forward(request, response);
    }
}
