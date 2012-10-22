/**
 * 
 */
package com.epam.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.epam.news.bean.News;
import com.epam.news.database.DAOImpl;

/**
 * @author Sergey
 * 
 */
public class TestThread implements Runnable {
    Thread th;

    public TestThread() {
    }

    public TestThread(String name) {
	th = new Thread(this, name);
	th.run();
    }

    @Override
    public void run() {
	try {
	    System.out.println("Thread " + th.getName() + "started!");
	    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
	    DAOImpl dao = new DAOImpl();
	    List<News> list = new ArrayList<News>();
	    list = dao.getAll();
	    System.out.println("Thread " + th.getName() + "finished!");
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }
}
