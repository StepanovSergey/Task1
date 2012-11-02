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
import com.epam.news.forms.SaveNewsForm;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class SaveNewsAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = "failure";
	if (form != null) {
	    SaveNewsForm newsForm = (SaveNewsForm) form;
	    News news = newsForm.getNews();
	    System.out.println("News = " + news);
	    target = "success";
	}
	return (mapping.findForward(target));
    }
}
