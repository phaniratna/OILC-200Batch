package com;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class FileLocationListener
 *
 */
@WebListener
public class FileLocationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FileLocationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
          String rootPath = System.getProperty("catalina.home");
          ServletContext ctx = arg0.getServletContext();
          ctx.setAttribute("tempfile.dir", "tmpfiles");
          String relativePath = (String)ctx.getAttribute("tempfile.dir");
          File file = new File(rootPath + File.pathSeparator+relativePath);
          System.out.println(file.getPath());
          if(!file.exists()) {
        	  file.mkdirs();
        	  System.out.println("File directory is created to be used for storing files");
        	  ctx.setAttribute("FILE_DIR_FILE", file);
        	  ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
          }
          
          
    }
	
}
