package com.ray.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ray.dao.AlertDao;
import com.ray.dao.ResLinkDao;
import com.ray.entity.Alert;
import com.ray.entity.ResLink;
import com.ray.eye.CrawlerFactory;

/**
 * 定时器，定时去爬取数据
 * @author Ray
 * @date 2015年6月18日14:30:00
 * @version 1.0
 */
@Component
public class CrawlerTask {

	/** 文章的相关操作数据库接口*/
	@Autowired
	private AlertDao dao;
	
	/** 分类来源的相关操作数据库接口*/
	@Autowired
	private ResLinkDao linkDao;
	
	private static String count = "0";
	private static boolean one = true;
	private static boolean two = true;
	private static boolean three = true;
	
	/** 11点的时候触发*/
	@Scheduled(cron="0 0 11 ? * * ")
//	@Scheduled(cron="0 20 17 ? * * ")
	public void oneCrawle(){
		crale(0);
	}
	
	/** 15点的时候触发*/
	@Scheduled(cron="0 0 15 ? * * ")
//	@Scheduled(cron="0 23 17 ? * * ")
	public void twoCrawle(){
		crale(1);
	}
	
	/** 0点的时候触发*/
	@Scheduled(cron="0 58 23 ? * * ")
//	@Scheduled(cron="0 25 17 ? * * ")
	public void threeCrawle(){
		crale(2);
	}
	
	/**
	 * 爬去数据的方法
	 */
	private synchronized void crale(int index){
		synchronized (count) {
			switch (index) {
				case 0:
					if(!one){
						return;
					}
					three = true;
					one = false;
					break;
				case 1:
					if(!two){
						return;
					}
					one = true;
					two = false;
					break;
				case 2:
					if(!three){
						return;
					}
					two = true;
					three = false;
					break;
	
				default:
					break;
			}
			new CrawleThead().start();
//			System.out.println(System.currentTimeMillis()+"  threadid:"+Thread.currentThread().getId());
			
		}
	}
	
	/**
	 * 爬虫的线程
	 * @author Ray Wang
	 * @date 2015年6月23日19:21:08
	 * @version 1.0
	 */
	private  class CrawleThead extends Thread{
		

		public void run() {
			List<ResLink> links = linkDao.findAll();
			
			for(ResLink link : links){
				ArrayList<Alert> list = new CrawlerFactory().crawlerFactory(link);
				if(list != null && list.size() > 0){
					dao.add(list);
				}
			}
		}
	}
	
}
