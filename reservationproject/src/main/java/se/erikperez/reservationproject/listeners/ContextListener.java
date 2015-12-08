/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.erikperez.reservationproject.listeners;

import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import se.erikperez.reservationproject.datamanagement.DatabaseManager;

/**
 *
 * @author Erick
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = (ServletContext) event.getServletContext();
        context.log("Today's date: " + new Date(Calendar.getInstance().getTime().getTime()).toString());
        DatabaseManager databaseManager = (DatabaseManager) context.getAttribute("databaseManager");
        if (databaseManager == null) {
            synchronized (context) {
                databaseManager = new DatabaseManager();
                context.setAttribute("databaseManager", databaseManager);
                context.log("--- DatabaseManager initialized ---");
            }
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().log("--- contextDestroyed called ---");
    }

}
