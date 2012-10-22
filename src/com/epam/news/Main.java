package com.epam.news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.news.bean.News;
import com.epam.news.database.ConnectionPool;
import com.epam.news.database.DAOImpl;

/**
 * Main test class
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	/*ConnectionPool.init();
	DAOImpl dao = new DAOImpl();
	News news = new News();
	news = dao.getById(1);
	System.out.println(news);
	*/
	try {
	    //Class.forName(ConnectionPool.driverClass).newInstance();
	    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    Connection connection = DriverManager.getConnection(ConnectionPool.URI, ConnectionPool.user, ConnectionPool.password);
	    ResultSet rs = connection.createStatement().executeQuery("Select * from news");
	    System.out.println("RS = " + rs.toString());
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
    }
}
