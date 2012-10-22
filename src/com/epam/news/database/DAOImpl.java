package com.epam.news.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.news.bean.News;

/**
 * This class provides DAO implementation
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class DAOImpl implements DAO {
    private static final Logger log = Logger.getLogger(DAOImpl.class);

    @Override
    public List<News> getAll() {
	List<News> allNews = new ArrayList<News>();
	Connection connection = ConnectionPool.getConnection();
	try {
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM news");
	    
	} catch (SQLException e) {
	    log.error(e.getMessage());
	}
	return allNews;
    }

    @Override
    public News getById(int id) {
	News news = new News();
	Connection connection = ConnectionPool.getConnection();
	PreparedStatement preparedStatement;
	try {
	    preparedStatement = connection.prepareStatement("Select * from news where id=?");
	    preparedStatement.setInt(0, id);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    news = setParameters(resultSet);
	} catch (SQLException e) {
	    log.error(e.getMessage());
	}
	return news;
    }

    @Override
    public void addNews(News news) {
	// TODO Auto-generated method stub

    }

    @Override
    public void updateNews(int id) {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteNews(int id) {
	// TODO Auto-generated method stub

    }
    
    private News setParameters(ResultSet resultSet){
	News news = new News();
	try {
	    news.setId(resultSet.getInt("id"));
	    news.setTitle(resultSet.getString("title"));
	    news.setDate(resultSet.getDate("news_date"));
	    news.setBrief(resultSet.getString("brief"));
	    news.setContent(resultSet.getString("content"));
	} catch (SQLException e) {
	    log.error(e.getMessage());
	}
	return news;
    }

}
