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
    private Connection connection;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private static final String getAllQuery = "SELECT * FROM news";
    private static final String getByIdQuery = "SELECT * FROM news WHERE id=?";
    private static final String addNewsQuery = "INSERT INTO news(title,news_date,brief,content) VALUES (?,?,?,?)";
    private static final String updateNewsQuery = "UPDATE news SET title=?, news_date=?, brief=?, content=? where id=?";

    @Override
    public List<News> getAll() {
	List<News> allNews = new ArrayList<News>();
	Connection connection = ConnectionPool.getConnection();
	try {
	    statement = connection.createStatement();
	    resultSet = statement.executeQuery(getAllQuery);
	    while (resultSet.next()) {
		News news = setParameters(resultSet);
		allNews.add(news);
	    }
	} catch (SQLException e) {
	    log.error(e.getMessage(), e);
	} finally {
	    releaseResources(statement, resultSet);
	    ConnectionPool.releaseConnection(connection);
	}
	return allNews;
    }

    @Override
    public News getById(int id) {
	News news = new News();
	Connection connection = ConnectionPool.getConnection();
	try {
	    preparedStatement = connection.prepareStatement(getByIdQuery);
	    preparedStatement.setInt(1, id);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
		news = setParameters(resultSet);
	    }
	} catch (SQLException e) {
	    log.error(e.getMessage(), e);
	} finally {
	    releaseResources(statement, resultSet);
	    ConnectionPool.releaseConnection(connection);
	}
	return news;
    }

    @Override
    public void addNews(News news) {
	connection = ConnectionPool.getConnection();
	try {
	    preparedStatement = connection.prepareStatement(addNewsQuery);
	    preparedStatement.setString(1, news.getTitle());
	    preparedStatement.setDate(2, news.getDate());
	    preparedStatement.setString(3, news.getBrief());
	    preparedStatement.setString(4, news.getContent());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    log.error(e.getMessage(), e);
	} finally {
	    releaseResources(statement, resultSet);
	    ConnectionPool.releaseConnection(connection);
	}
    }

    @Override
    public void updateNews(News news) {
	connection = ConnectionPool.getConnection();
	try {
	    preparedStatement = connection.prepareStatement(updateNewsQuery);
	    preparedStatement.setString(1, news.getTitle());
	    preparedStatement.setDate(2, news.getDate());
	    preparedStatement.setString(3, news.getBrief());
	    preparedStatement.setString(4, news.getContent());
	    preparedStatement.setInt(5, news.getId());
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    log.error(e.getMessage(), e);
	} finally {
	    releaseResources(statement, resultSet);
	    ConnectionPool.releaseConnection(connection);
	}
    }

    @Override
    public void deleteNews(int id) {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteManyNews(Integer[] ids) {
	// TODO Auto-generated method stub

    }

    private News setParameters(ResultSet resultSet) {
	News news = new News();
	try {
	    news.setId(resultSet.getInt("id"));
	    news.setTitle(resultSet.getString("title"));
	    news.setDate(resultSet.getDate("news_date"));
	    news.setBrief(resultSet.getString("brief"));
	    news.setContent(resultSet.getString("content"));
	} catch (SQLException e) {
	    log.error(e.getMessage(), e);
	}
	return news;
    }

    private void releaseResources(Statement statement, ResultSet resultSet) {
	if (statement != null) {
	    try {
		statement.close();
	    } catch (SQLException e) {
		log.error(e.getMessage(), e);
	    }
	}
	if (resultSet != null) {
	    try {
		resultSet.close();
	    } catch (SQLException e) {
		log.error(e.getMessage(), e);
	    }
	}
    }
}
