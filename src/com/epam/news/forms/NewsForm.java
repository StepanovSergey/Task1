package com.epam.news.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.epam.news.bean.News;

/**
 * This class provides news form
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class NewsForm extends ActionForm {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 1216355468781937508L;
    private List<News> newsList = new ArrayList<News>();
    private News news = new News();
    private String lang;
    private Integer[] selectedItems;

    /**
     * @return the selectedItems
     */
    public Integer[] getSelectedItems() {
	return selectedItems;
    }

    /**
     * @param selectedItems
     *            the selectedItems to set
     */
    public void setSelectedItems(Integer[] selectedItems) {
	this.selectedItems = selectedItems;
    }

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

    /**
     * @return the lang
     */
    public String getLang() {
	return lang;
    }

    /**
     * @param lang
     *            the lang to set
     */
    public void setLang(String lang) {
	this.lang = lang;
    }
}
