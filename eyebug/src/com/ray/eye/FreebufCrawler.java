package com.ray.eye;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;
/**
 * 黑客与极客的网站的爬虫
 * @author Ray Wang
 * @date 2015年5月20日16:19:25
 * @version 1.0
 */
public class FreebufCrawler implements Crawler {
	
	public static final String NOWURL = "http://www.freebuf.com/";

	public ArrayList<Alert> crawlerList(ResLink link) {
		ArrayList<Alert> alerts = new ArrayList<Alert>();
		try {
			URL url = new URL(link.getUrl());
			Document document = Jsoup.parse(url, TIMEOUT);
			Elements es = document.getElementsByClass("news-list");
			for(int i = 0;i < es.size();i++){
				Alert temp = new Alert();
				Element e = es.get(i);
				
				temp.setTitle(e.getElementsByClass("news-info").get(0).
						getElementsByTag("a").get(0).html());
				temp.setImg(e.getElementsByTag("img").attr("src"));
				temp.setDesc1(e.getElementsByClass("text").get(0).html());
				temp.setAlerttime(e.getElementsByClass("time").get(0).html());
				temp.setUrl(e.getElementsByClass("news-info").get(0).getElementsByTag("a").
						get(0).attr("href"));
				if(temp.getUrl().indexOf("http://www.freebuf.com/jobs") == 0){
					//招聘信息，跳过
					continue;
				}
				if(!crawlerAlert(temp)){
					//爬取失败或者不允许转载
					continue;
				}
				
				temp.setResId(link.getResid());
				temp.setAtypeId(link.getTypeid());
				temp.setResLinkId(link.getId());
				
				alerts.add(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alerts;
	}

	public boolean crawlerAlert(Alert alert) {
		try {
			URL url = new URL(alert.getUrl());
			Document document = Jsoup.parse(url, TIMEOUT);
			String str = document.getElementById("contenttxt").html();
			if(str.indexOf("未经许可禁止转载") > 0){
				return false;
			}
			alert.setContent(str);
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
