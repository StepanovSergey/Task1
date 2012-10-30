/**
 * 
 */
package com.epam.news.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.epam.news.bean.News;
import com.epam.news.database.DAOImpl;

/**
 * @author Siarhei_Stsiapanau
 *
 */
public class NewsListAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = "failure";
	DAOImpl dao = new DAOImpl();
	List<News> list = dao.getAll();
	if (list != null) {
	    request.getSession().setAttribute("newsList", list);
	    target = "success";
	}
	return (mapping.findForward(target));
    }
}
