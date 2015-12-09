package se.erikperez.reservationproject.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import se.erikperez.reservationproject.datamanagement.DatabaseManager;

/**
 * This class represents the context listener to the project
 *
 * @see ServletContextListener
 * @author Erik Perez
 * @version 1.0
 * @since 09/12/2015
 */
public class ContextListener implements ServletContextListener {

    /**
     * @see
     * ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     * @param event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = (ServletContext) event.getServletContext();
        //initialize the DatabaseManager class
        DatabaseManager databaseManager = (DatabaseManager) context.getAttribute("databaseManager");
        if (databaseManager == null) {
            synchronized (context) {
                databaseManager = new DatabaseManager();
                //setting an attribute to the databaseManager class
                context.setAttribute("databaseManager", databaseManager);
                context.log("--- DatabaseManager initialized ---");
            }
        }

    }

    /**
     * @see
     * ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     * @param event
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().log("--- contextDestroyed called ---");
    }

}
