package com.epam.news.actions;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.epam.news.bean.News;
import com.epam.news.database.NewsDAO;
import com.epam.news.forms.NewsForm;

/**
 * This class provides all actions of application.
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public final class NewsAction extends MappingDispatchAction {
    private static final Logger log = Logger.getLogger(NewsAction.class);
    private static final String MAIN_PAGE = "mainPage";
    private static final String NEWS_LIST_PAGE = "newsList";
    private static final String VIEW_NEWS_PAGE = "viewNews";
    private static final String ADD_NEWS_PAGE = "addNews";
    private static final String EDIT_NEWS_PAGE = "editNews";
    private static final String ERROR_PAGE = "error";
    private static final String PREVIOUS_PAGE = "previousPage";
    private NewsDAO newsDao;

    /**
     * @return the newsDao
     */
    public NewsDAO getNewsDao() {
	return newsDao;
    }

    /**
     * @param newsDao
     *            the newsDao to set
     */
    public void setNewsDao(NewsDAO newsDao) {
	this.newsDao = newsDao;
    }

    /**
     * Action named /NewsList. Shows list of all news.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward viewNewsList(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	request.getSession().setAttribute(PREVIOUS_PAGE, NEWS_LIST_PAGE);
	NewsForm newsForm = (NewsForm) form;
	List<News> newsList = newsDao.getAll();
	if (newsList != null) {
	    target = NEWS_LIST_PAGE;
	    newsForm.setNewsList(newsList);
	}
	return mapping.findForward(target);
    }

    /**
     * Action named /AddNews. Forwards to Add News page
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward addNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ADD_NEWS_PAGE;
	NewsForm newsForm = (NewsForm) form;
	News news = new News();
	Calendar calendar = Calendar.getInstance();
	Date today = new Date(calendar.getTimeInMillis());
	news.setDate(today);
	newsForm.setNews(news);
	return mapping.findForward(target);
    }

    /**
     * Action named /EditNews. Forwards to Edit News page.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward editNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	if (setNewsDetails(request, form)) {
	    target = EDIT_NEWS_PAGE;
	}
	return (mapping.findForward(target));
    }

    /**
     * Action named /ViewNews. Forwards to View News page.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward viewNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	if (setNewsDetails(request, form)) {
	    target = VIEW_NEWS_PAGE;
	}
	request.getSession().setAttribute(PREVIOUS_PAGE, VIEW_NEWS_PAGE);
	return (mapping.findForward(target));
    }

    /**
     * Action named /DeleteNews. Delete news from View News page or Edit News
     * page.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward deleteNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	NewsForm newsForm = (NewsForm) form;
	if (newsForm != null) {
	    int id = newsForm.getNews().getId();
	    Integer[] ids = { id };
	    int result = newsDao.deleteManyNews(ids);
	    if (result == 1) {
		target = MAIN_PAGE;
		log.info("News delete with id = " + id);
	    }
	}
	return (mapping.findForward(target));
    }

    /**
     * Action named /DeleteGroupOfNews. Delete one or more news from News List
     * page.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward deleteGroupOfNews(ActionMapping mapping,
	    ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	String target = ERROR_PAGE;
	if (form != null) {
	    NewsForm newsForm = (NewsForm) form;
	    Integer[] selectedItems = newsForm.getSelectedItems();
	    if (selectedItems.length > 0) {
		int result = newsDao.deleteManyNews(selectedItems);
		if (result > 0) {
		    target = MAIN_PAGE;
		    log.info("News multiple delete");
		}
	    }
	}
	return (mapping.findForward(target));
    }

    /**
     * Action named /Save. Save current news from Add News page or Edit News
     * page.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward save(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	NewsForm newsForm = (NewsForm) form;
	if (newsForm != null) {
	    int id = newsForm.getNews().getId();
	    boolean result = false;
	    if (id == 0) {
		// add page save
		String title = newsForm.getNews().getTitle();
		int numRows = newsDao.getByTitle(title);
		if (numRows == 0) {
		    result = addNewsSaveButton(newsForm);
		}
	    } else {
		// edit page save
		result = editNewsSaveButton(newsForm, id);
	    }
	    if (result) {
		target = VIEW_NEWS_PAGE;
	    }
	}
	return (mapping.findForward(target));
    }

    /**
     * Action named /Cancel. Cancel current operation and go back to previous
     * page.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward cancel(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = (String) request.getSession().getAttribute(
		PREVIOUS_PAGE);
	return (mapping.findForward(target));
    }

    public ActionForward back(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	return cancel(mapping, form, request, response);
    }

    /**
     * Action named /ChangeLocale. Changes current locale to another.
     * 
     * @param mapping
     *            ActionMapping of this action
     * @param form
     *            form of this action
     * @param request
     *            current request
     * @param response
     *            current response
     * @return forward to page
     * @throws Exception
     *             if something is wrong
     */
    public ActionForward changeLocale(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	if (form != null) {
	    NewsForm newsForm = (NewsForm) form;
	    String lang = newsForm.getLang();
	    setLocale(request, new Locale(lang));
	    target = (String) request.getSession().getAttribute(PREVIOUS_PAGE);
	}
	return (mapping.findForward(target));
    }

    private boolean setNewsDetails(HttpServletRequest request, ActionForm form) {
	NewsForm newsForm = (NewsForm) form;
	if (newsForm != null) {
	    int id = newsForm.getNews().getId();
	    News news = newsDao.getById(id);
	    newsForm.setNews(news);
	    return true;
	} else {
	    return false;
	}
    }

    private boolean addNewsSaveButton(NewsForm form) {
	NewsForm newsForm = (NewsForm) form;
	News news = newsForm.getNews();
	int result = newsDao.addNews(news);
	if (result > 0) {
	    log.info("Add news");
	    return true;
	}
	return false;
    }

    private boolean editNewsSaveButton(NewsForm form, int id) {
	NewsForm newsForm = (NewsForm) form;
	News news = newsForm.getNews();
	int result = newsDao.updateNews(news);
	if (result > 0) {
	    log.info("Edit news with id = " + news.getId());
	    return true;
	}
	return false;
    }
}
