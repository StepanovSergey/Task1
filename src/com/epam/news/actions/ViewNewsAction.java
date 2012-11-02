/**
 * 
 */
package com.epam.news.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.epam.news.bean.News;
import com.epam.news.database.DAOImpl;
import com.epam.news.forms.ViewNewsForm;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class ViewNewsAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = "failure";
	DAOImpl dao = new DAOImpl();
	String idS = request.getParameter("id");
	int id = Integer.parseInt(idS);
	News news = dao.getById(id);
	if (news != null) {
	    ViewNewsForm newsForm = (ViewNewsForm) form;
	    newsForm.setNews(news);
	    target = "success";
	}
	return (mapping.findForward(target));
    }
}
