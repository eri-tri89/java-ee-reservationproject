/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.listeners;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import se.erikperez.reservationproject.dataManagement.DatabaseManager;
import se.erikperez.reservationproject.model.Booking;

/**
 *
 * @author Erick
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = (ServletContext)event.getServletContext();
        synchronized (context) {
            DatabaseManager databaseManager = new DatabaseManager();            
            context.setAttribute("databaseManager", databaseManager);
            context.log("--- DatabaseManager initialized ---");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext context = (ServletContext)event.getServletContext();
        synchronized (context) {
            DatabaseManager databaseManager = (DatabaseManager) context.getAttribute("databaseManager");
            databaseManager = null;
            context.log("--- DatabaseManager destroyed ---");
        }
    }

}
