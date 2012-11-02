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
public class EditNewsForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = -788999996379185465L;
    private int id;
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

    /**
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

}
