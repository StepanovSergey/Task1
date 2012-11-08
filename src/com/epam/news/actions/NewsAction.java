package com.epam.news.actions;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.epam.news.bean.News;
import com.epam.news.database.DAO;
import com.epam.news.forms.DeleteNewsForm;
import com.epam.news.forms.NewsForm;

public class NewsAction extends MappingDispatchAction {
    private static final String MAIN_PAGE = "mainPage";
    private static final String NEWS_LIST_PAGE = "newsList";
    private static final String VIEW_NEWS_PAGE = "viewNews";
    private static final String ADD_NEWS_PAGE = "addNews";
    private static final String EDIT_NEWS_PAGE = "editNews";
    private static final String ERROR_PAGE = "error";
    private static final String PREVIOUS_PAGE = "previousPage";
    private static final String CURRENT_PAGE = "currentPage";
    private DAO dao;

    /**
     * Get DAO
     * 
     * @return the dao
     */
    public DAO getDao() {
	return dao;
    }

    /**
     * Set DAO
     * 
     * @param dao
     *            the dao to set
     */
    public void setDao(DAO dao) {
	this.dao = dao;
    }

    public ActionForward viewNewsList(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	setPageHistory(request, NEWS_LIST_PAGE);
	NewsForm newsForm = (NewsForm) form;
	List<News> newsList = dao.getAll();
	if (newsList != null) {
	    target = NEWS_LIST_PAGE;
	    newsForm.setNewsList(newsList);
	}
	return mapping.findForward(target);
    }

    public ActionForward addNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ADD_NEWS_PAGE;
	setPageHistory(request, ADD_NEWS_PAGE);
	NewsForm newsForm = (NewsForm) form;
	News news = new News();
	Calendar calendar = Calendar.getInstance();
	Date today = new Date(calendar.getTimeInMillis());
	news.setDate(today);
	newsForm.setNews(news);
	return mapping.findForward(target);
    }

    public ActionForward editNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = getNews(request, form, EDIT_NEWS_PAGE);
	return (mapping.findForward(target));
    }

    public ActionForward viewNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = getNews(request, form, VIEW_NEWS_PAGE);
	return (mapping.findForward(target));
    }

    public ActionForward deleteNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = "";
	setPageHistory(request);
	String idS = request.getParameter("id");
	if (idS != null) {
	    int id = Integer.parseInt(idS);
	    System.out.println("You would to delete news with id = " + id);
	    target = MAIN_PAGE;
	}
	return (mapping.findForward(target));
    }

    public ActionForward deleteGroupOfNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	setPageHistory(request);
	if (form != null) {
	    NewsForm newsForm = (NewsForm) form;
	    Integer[] selectedItems = newsForm.getSelectedItems();
	    if (selectedItems.length > 0) {
		for (Integer id : selectedItems) {
		    System.out.println("You would to delete news with id = " + id);
		}
	    }
	    target = NEWS_LIST_PAGE;
	}
	return (mapping.findForward(target));
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	setPageHistory(request);
	String target = ERROR_PAGE;
	String idS = request.getParameter("news.id");
	if (idS != null) {
	    int id = Integer.parseInt(idS);
	    if (id == 0) {
		// add page save
		addNewsSaveButton(form, request);
	    } else {
		// edit page save
		editNewsSaveButton(form, id);
	    }
	    target = MAIN_PAGE;
	}
	return (mapping.findForward(target));
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	setPageHistory(request);
	NewsForm newsForm = (NewsForm) form;
	newsForm.setNews(new News());
	String target = NEWS_LIST_PAGE;
	return (mapping.findForward(target));
    }

    public ActionForward changeLocale(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = ERROR_PAGE;
	setPageHistory(request);
	if (form != null) {
	    NewsForm newsForm = (NewsForm) form;
	    String lang = newsForm.getLang();
	    if ("ru".equals(lang)) {
		setLocale(request, new Locale("ru"));
	    } else {
		setLocale(request, new Locale("en"));
	    }
	    target = getPreviousPageForward(request);
	}
	return (mapping.findForward(target));
    }

    private void setPageHistory(HttpServletRequest request, String currentPage) {
	HttpSession session = request.getSession();
	String previousPage = (String) session.getAttribute(CURRENT_PAGE);
	session.setAttribute(PREVIOUS_PAGE, previousPage);
	if (currentPage.equals("prevPage")) {
	    currentPage = previousPage;
	}
	session.setAttribute(CURRENT_PAGE, currentPage);
    }

    private void setPageHistory(HttpServletRequest request) {
	setPageHistory(request, "prevPage");
    }

    private String getPreviousPageForward(HttpServletRequest request) {
	HttpSession session = request.getSession();
	return (String) session.getAttribute(PREVIOUS_PAGE);
    }

    private String getNews(HttpServletRequest request, ActionForm form,
	    String target) {
	setPageHistory(request, target);
	String idS = request.getParameter("id");
	if (idS != null) {
	    int id = Integer.parseInt(idS);
	    News news = dao.getById(id);
	    if (news != null) {
		NewsForm newsForm = (NewsForm) form;
		newsForm.setNews(news);
	    }
	}
	return target;
    }

    private void addNewsSaveButton(ActionForm form, HttpServletRequest request) {
	NewsForm newsForm = (NewsForm) form;
	News news = newsForm.getNews();
	System.out.println("You would to add news = " + news);
    }

    private void editNewsSaveButton(ActionForm form, int id) {
	NewsForm newsForm = (NewsForm) form;
	News news = newsForm.getNews();
	System.out.println("You would to edit news = " + news);
    }
}
