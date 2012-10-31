package com.epam.news.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Siarhei_Stsiapanau
 *
 */
public class ChangeLocaleForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = -9053434186590306468L;
    
    private String lang;

    /**
     * @return the lang
     */
    public String getLang() {
	return lang;
    }

    /**
     * @param lang
     *            the lang to set
     */
    public void setLang(String lang) {
	this.lang = lang;
    }
}
