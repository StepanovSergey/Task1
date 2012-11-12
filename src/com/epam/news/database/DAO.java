package com.epam.news.database;

import java.util.List;

import com.epam.news.bean.News;

/**
 * This interface provides DAO interface for news table
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
/**
 * @author Sergey
 * 
 */
public interface DAO {
    /**
     * Get all news from database
     * 
     * @return list of all news
     */
    public List<News> getAll();

    /**
     * Get news by id from database
     * 
     * @param id
     *            the id of news
     * @return news from database
     */
    public News getById(int id);

    /**
     * Add news to database
     * 
     * @param news
     *            news to add
     * @return number of affected rows. Must be equal 1.
     */
    public int addNews(News news);

    /**
     * Update news
     * 
     * @param news
     *            news to update
     * @return number of affected rows. Must be equal 1.
     */
    public int updateNews(News news);

    /**
     * Delete many news by ids
     * 
     * @param ids
     *            array of ids
     * @return number of affected rows
     */
    public int deleteManyNews(Integer[] ids);

    /**
     * Delete one news
     * 
     * @param id
     *            the id of news
     * @return number of affected rows. Must be equal 1.
     */
    public int deleteNews(int id);

    /**
     * Get news by its title
     * @param newsTitle
     *            title of news
     * @return number of rows of news with given title
     */
    public int getByTitle(String newsTitle);

}
