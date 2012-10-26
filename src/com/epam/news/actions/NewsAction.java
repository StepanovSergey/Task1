package com.epam.news.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.epam.news.database.DAO;
import com.epam.news.forms.NewsForm;

public class NewsAction extends Action {
    private DAO dao;

    /**
     * Get DAO
     * @return the dao
     */
    public DAO getDao() {
	return dao;
    }

    /**
     * Set DAO
     * @param dao
     *            the dao to set
     */
    public void setDao(DAO dao) {
	this.dao = dao;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = new String("success");
	String name = null;
	if (form != null) {
	    // Use the NameForm to get the request parameters
	    NewsForm newsForm = (NewsForm) form;
	    name = newsForm.getName();
	}
	// if no mane supplied Set the target to failure
	if (name == null) {
	    target = new String("failure");
	} else {
	    request.setAttribute("NAME", name);
	}
	return (mapping.findForward(target));
    }
}
