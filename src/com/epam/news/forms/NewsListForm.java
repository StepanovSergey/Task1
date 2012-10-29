/**
 * 
 */
package com.epam.news.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.epam.news.bean.News;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class NewsListForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 8588676114861176437L;

    private List<News> newsList = new ArrayList<News>();

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

}
