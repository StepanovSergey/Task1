package com.epam.news.actions;

import java.util.ArrayList;
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
import com.epam.news.forms.NewsForm;

public class NewsAction extends MappingDispatchAction {
    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";
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
	String target = FAILURE;
	NewsForm newsForm = (NewsForm) form;
	ArrayList<News> newsList = (ArrayList<News>) dao.getAll();
	if (newsList != null) {
	    target = SUCCESS;
	    newsForm.setNewsList(newsList);
	}
	return mapping.findForward(target);
    }
    
    public ActionForward addNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = SUCCESS;
	return mapping.findForward(target);
    }
    
    public ActionForward editNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = FAILURE;
	String idS = request.getParameter("id");
	if (idS != null) {
	    int id = Integer.parseInt(idS);
	    News news = dao.getById(id);
	    if (news != null) {
		NewsForm newsForm = (NewsForm) form;
		newsForm.setNews(news);
		target = SUCCESS;
	    }
	}
	return (mapping.findForward(target));
    }
    
    public ActionForward viewNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = FAILURE;
	String idS = request.getParameter("id");
	int id = Integer.parseInt(idS);
	News news = dao.getById(id);
	if (news != null) {
	    NewsForm newsForm = (NewsForm) form;
	    newsForm.setNews(news);
	    target = SUCCESS;
	}
	return (mapping.findForward(target));
    }
    
    public ActionForward deleteNews(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = SUCCESS;
	if (form != null) {
	    NewsForm deleteForm = (NewsForm) form;
	    Integer[] selectedItems = deleteForm.getSelectedItems();
	    if (selectedItems.length > 0) {
		for (Integer id : selectedItems) {
		    System.out.println("Selected id = " + id);
		}
	    }
	    target = "success";
	}
	return (mapping.findForward(target));
    }
    
    public ActionForward save(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = SUCCESS;
	return (mapping.findForward(target));
    }
    
    public ActionForward cancel(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = SUCCESS;
	HttpSession session = request.getSession();
	session.invalidate();
	return (mapping.findForward(target));
    }
    
    public ActionForward changeLocale(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	String target = FAILURE;
	if (form != null) {
	    NewsForm newsForm = (NewsForm) form;
	    String lang = newsForm.getLang();
	    if ("ru".equals(lang)) {
		setLocale(request, new Locale("ru"));
	    } else {
		setLocale(request, new Locale("en"));
	    }
	    target = SUCCESS;
	}
	return (mapping.findForward(target));
    }
}
