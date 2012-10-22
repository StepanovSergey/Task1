package com.epam.news;

import com.epam.news.database.ConnectionPool;

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

	ConnectionPool.init();
	/*
	 * DAOImpl dao = new DAOImpl(); News news = new News(); news =
	 * dao.getById(1); System.out.println(news);
	 */
	for (int i = 0; i < 8; i++) {
	    TestThread th = new TestThread("th" + i);
	}
	/*
	 * try { Class.forName(ConnectionPool.driverClass); Connection
	 * connection = DriverManager.getConnection( ConnectionPool.URI,
	 * ConnectionPool.user, ConnectionPool.password); ResultSet rs =
	 * connection.createStatement().executeQuery( "Select * from news");
	 * while (rs.next()) { System.out.println(rs.getString("title")); } }
	 * catch (SQLException | ClassNotFoundException e) {
	 * e.printStackTrace(); }
	 */
    }
}
