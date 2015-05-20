package com.ray.eye;

import java.util.ArrayList;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;
/**
 * 爬虫工厂类
 * @author Ray Wang
 * @date 2015年5月20日11:16:01
 * @version 1.0
 */
public class CrawlerFactory {

	/**
	 * 根据不同的URL创建不同的爬虫类
	 * @param link 分类来源对象
	 * @return 文章集合
	 */
	public ArrayList<Alert> crawlerFactory(ResLink link){
		Crawler crawler = null;
		
		if(link.getUrl().equals(InfoqAlert.NOWURL)){
			crawler = new InfoqAlert();
		}else if(link.getUrl().equals(InfoqNew.NOWURL)){
			crawler = new InfoqNew();
		}
		
		return crawler.crawlerList(link);
	}
}
