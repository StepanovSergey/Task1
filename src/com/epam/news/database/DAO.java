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
     */
    public void addNews(News news);

    /**
     * Update news
     * 
     * @param news
     *            news to update
     */
    public void updateNews(News news);

    /**
     * Delete news by id
     * 
     * @param id
     *            id of the news to delete
     */
    public void deleteNews(int id);

    /**
     * Delete many news by ids
     * 
     * @param ids
     *            array of ids
     */
    public void deleteManyNews(Integer[] ids);
}
