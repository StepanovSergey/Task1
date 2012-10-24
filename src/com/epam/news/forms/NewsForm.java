package com.epam.news.forms;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

/**
 * This class provides news form
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class NewsForm extends ActionForm {
    private static final Logger log = Logger.getLogger(NewsForm.class);

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 1216355468781937508L;
    private String name;

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }
}
