package com.epam.news.database;

import java.util.List;

import com.epam.news.bean.News;

/**
 * This interface provides DAO interface for news table
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public interface DAO {
    public List<News> getAll();

    public News getById(int id);

    public void addNews(News news);

    public void updateNews(int id);

    public void deleteNews(int id);
}
