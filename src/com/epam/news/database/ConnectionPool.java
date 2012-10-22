package com.epam.news.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

/**
 * This class provides connection pool
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class ConnectionPool {
    private static final Logger log = Logger.getLogger(ConnectionPool.class);
    public static final String driverClass = "oracle.jdbc.driver.OracleDriver";
    public static final String URI = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String user = "SYSTEM";
    public static final String password = "root";
    private static final int poolSize = 5;
    private static ConnectionPool instance = new ConnectionPool();
    private static Queue<Connection> occupiedConnections = new ConcurrentLinkedQueue<Connection>();
    private static Queue<Connection> freeConnections = new ConcurrentLinkedQueue<Connection>();
    private static Semaphore semaphore = new Semaphore(poolSize, true);

    private ConnectionPool() {
    }

    public static void init() {
	try {
	    Class.forName(driverClass);
	    for (int i = 0; i < poolSize; i++) {
		Connection connection = openConnection();
		freeConnections.add(connection);
	    }
	} catch (ClassNotFoundException e) {
	    log.error(e.getMessage());
	}
    }

    public static Connection getConnection() {
	Connection connection = null;
	try {
	    semaphore.acquire();
	    connection = freeConnections.poll();
	    occupiedConnections.add(connection);
	} catch (InterruptedException e) {
	    log.error(e.getMessage());
	}
	return connection;
    }

    public static ConnectionPool getInstance() {
	return instance;
    }

    private static Connection openConnection() {
	Connection connection = null;
	try {
	    connection = DriverManager.getConnection(URI, user, password);
	} catch (SQLException e) {
	    log.error(e.getMessage());
	}
	return connection;
    }

    public static void releaseConnection(Connection connection) {
	occupiedConnections.remove(connection);
	try {
	    if (connection.isClosed()) {
		connection = openConnection();
	    }
	    freeConnections.add(connection);
	    semaphore.release();
	} catch (SQLException e) {
	    log.error(e.getMessage());
	}
    }
}
