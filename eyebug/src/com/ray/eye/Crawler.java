package com.ray.eye;

import java.util.ArrayList;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;

/**
 * 爬虫的接口
 * @author Ray Wang
 * @date 2015年5月20日10:06:46
 * @version 1.0
 */
public interface Crawler {
	
	public static final int TIMEOUT = 60000;

	/**
	 * 爬取文章列表的方法
	 * @param url 列表地址
	 * @param title 最后一个爬取的标题
	 * @return 文章集合
	 */
	public ArrayList<Alert> crawlerList(ResLink link);
	
	/** 
	 * 爬取文章内容
	 * @param alert 文章对象
	 */
	public boolean crawlerAlert(Alert alert);
}
