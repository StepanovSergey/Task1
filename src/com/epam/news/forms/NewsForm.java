package com.epam.news.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.epam.news.bean.News;

/**
 * This class provides news form
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class NewsForm extends ActionForm {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 1216355468781937508L;
    private List<News> newsList = new ArrayList<News>();
    private News news = new News();

    /**
     * @return the newsList
     */
    public List<News> getNewsList() {
	return newsList;
    }

    /**
     * @param newsList
     *            the newsList to set
     */
    public void setNewsList(List<News> newsList) {
	this.newsList = newsList;
    }

    /**
     * @return the news
     */
    public News getNews() {
	return news;
    }

    /**
     * @param news
     *            the news to set
     */
    public void setNews(News news) {
	this.news = news;
    }
}
