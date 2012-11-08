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
import com.epam.news.forms.EditNewsForm;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class EditNewsAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = "success";
	String idS = request.getParameter("id");
	if (idS != null) {
	    int id = Integer.parseInt(idS);
	    DAOImpl dao = new DAOImpl();
	    News news = dao.getById(id);
	    if (news != null) {
		EditNewsForm newsForm = (EditNewsForm) form;
		newsForm.setId(id);
		newsForm.setNews(news);
	    }
	}
	return (mapping.findForward(target));
    }
}