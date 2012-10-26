package com.epam.news;

import java.util.List;

import com.epam.news.bean.News;
import com.epam.news.database.ConnectionPool;
import com.epam.news.database.DAO;
import com.epam.news.database.DAOImpl;

/**
 * Main test class
 * 
 * @author Siarhei_Stsiapanau
 * 
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println("===Init pool");
	ConnectionPool.init();
	DAO dao = new DAOImpl();
	News news = null;
	List<News> all = null;
	/*System.out.println("===Get all news");
	all = dao.getAll();
	System.out.println("All news = " + all);
	System.out.println("===Get by id");
	news = dao.getById(1);
	System.out.println("news#1 = " + news);
	System.out.println("===Add news");
	news.setId(10);
	news.setTitle("TitleNew");
	news.setDate(Date.valueOf("2012-10-26"));
	news.setBrief("Briefnew");
	news.setContent("ContentNew");
	dao.addNews(news);*/
	all = dao.getAll();
	//System.out.println("All news after add new news = " + all);
	System.out.println("===update news");
	news = all.get(0);
	news.setTitle("TitleNew2");
	news.setBrief("BriefNew222");
	dao.updateNews(news);
	all = dao.getAll();
	System.out.println("All news after update last news = " + all);
	/*System.out.println("===Delete news");
	//news = dao.getById(all.size());
	Integer[] ids = {1,2,all.size()}; 
	dao.deleteManyNews(ids);
	all = dao.getAll();
	System.out.println("All news after delete last news = " + all);*/
	
    }
}
