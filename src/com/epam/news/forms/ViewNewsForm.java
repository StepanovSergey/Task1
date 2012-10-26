/**
 * 
 */
package com.epam.news.forms;

/**
 * @author Siarhei_Stsiapanau
 *
 */
public class ViewNewsForm {
    private int idNews;
    private boolean edit = false;
    private boolean delete = false;
    /**
     * @return the idNews
     */
    public int getIdNews() {
        return idNews;
    }
    /**
     * @param idNews the idNews to set
     */
    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }
    /**
     * @return the edit
     */
    public boolean isEdit() {
        return edit;
    }
    /**
     * @param edit the edit to set
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    /**
     * @return the delete
     */
    public boolean isDelete() {
        return delete;
    }
    /**
     * @param delete the delete to set
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }
    
}
