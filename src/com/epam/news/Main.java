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
    }
}
