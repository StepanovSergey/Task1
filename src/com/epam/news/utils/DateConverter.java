package com.epam.news.utils;

/**
 * This class provides conversion between java.util.Date and java.sql.Date in
 * two sides
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class DateConverter {
    /**
     * Convert java.sql.Date to java.util.Date
     * 
     * @param sqlDate
     *            java.sql.Date to convert
     * @return java.util.Date date
     */
    public static java.util.Date convert(java.sql.Date sqlDate) {
	long timeInMillis = sqlDate.getTime();
	return new java.util.Date(timeInMillis);
    }

    /**
     * Convert java.util.Date to java.sql.Date
     * 
     * @param utilDate
     *            java.util.Date to convert
     * @return java.sql.Date date
     */
    public static java.sql.Date convert(java.util.Date utilDate) {
	long timeInMillis = utilDate.getTime();
	return new java.sql.Date(timeInMillis);
    }
}
