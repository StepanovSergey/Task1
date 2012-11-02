/**
 * 
 */
package com.epam.news.forms;

import org.apache.struts.action.ActionForm;

import com.epam.news.bean.News;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class SaveNewsForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = -2621260349932359115L;
    private News news;

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
