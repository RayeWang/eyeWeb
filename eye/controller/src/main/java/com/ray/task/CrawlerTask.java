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
	
	/** 11点的时候触发*/
	@Scheduled(cron="0 0 11 ? * * ")
	public void oneCrawle(){
		System.out.println("task is run");
	}
	
	/** 15点的时候触发*/
	@Scheduled(cron="0 0 15 ? * * ")
	public void twoCrawle(){
		List<ResLink> links = linkDao.findAll();
		for(ResLink link : links){
			ArrayList<Alert> list = new CrawlerFactory().crawlerFactory(link);
			if(list != null && list.size() > 0){
				dao.add(list);
			}
		}
	}
	
	/** 0点的时候触发*/
	@Scheduled(cron="0 58 23 ? * * ")
	public void threeCrawle(){
		List<ResLink> links = linkDao.findAll();
		for(ResLink link : links){
			ArrayList<Alert> list = new CrawlerFactory().crawlerFactory(link);
			if(list != null && list.size() > 0){
				dao.add(list);
			}
		}
	}
	
	
	
}
