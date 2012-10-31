package com.epam.news.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class DeleteNewsForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 3969145748503985759L;
    private Integer[] selectedItems;

    /**
     * @return the selectedItems
     */
    public Integer[] getSelectedItems() {
	return selectedItems;
    }

    /**
     * @param selectedItems
     *            the selectedItems to set
     */
    public void setSelectedItems(Integer[] selectedItems) {
	this.selectedItems = selectedItems;
    }

}
