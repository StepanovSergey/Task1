package com.epam.news.actions;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.epam.news.forms.ChangeLocaleForm;

/**
 * This action changes locale
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class ChangeLocaleAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = "failure";
	if (form != null) {
	    ChangeLocaleForm localeForm = (ChangeLocaleForm) form;
	    String lang = localeForm.getLang();
	    if ("ru".equals(lang)) {
		setLocale(request, new Locale("ru"));
	    } else {
		setLocale(request, new Locale("en"));
	    }
	    target="success";
	}
	return (mapping.findForward(target));
    }
}
