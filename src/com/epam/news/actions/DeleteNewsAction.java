package com.epam.news.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.epam.news.forms.DeleteNewsForm;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class DeleteNewsAction extends Action {
    private static final Logger log = Logger.getLogger(DeleteNewsAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String target = "failure";
	if (form != null) {
	    DeleteNewsForm deleteForm = (DeleteNewsForm) form;
	    Integer[] selectedItems = deleteForm.getSelectedItems();
	    if (selectedItems.length > 0) {
		for (Integer id : selectedItems) {
		    log.debug("Selected id = " + id);
		}
	    }
	    target = "success";
	}
	return (mapping.findForward(target));
    }
}
