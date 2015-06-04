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
 * http://www.codeceo.com/article/category/programmer
 *  （码农网---程序人生的分类）的爬虫程序
 * @author Ray Wang
 * @date 2015年5月24日21:23:54
 * @version 1.0
 */
public class CodeceoCrawler implements Crawler {
	
	public static final String NOWURL = "http://www.codeceo.com/article/category/develop";

	public ArrayList<Alert> crawlerList(ResLink link) {
		ArrayList<Alert> alerts = new ArrayList<Alert>();
		try {
			URL url = new URL(link.getUrl());
			Document document = Jsoup.parse(url, TIMEOUT);
			
			Elements elements = document.getElementsByClass("excerpt");
			for(int i = 0;i < elements.size();i++){
				Alert temp = new Alert();
				Element e = elements.get(i);
				temp.setTitle(e.getElementsByTag("a").get(1).html());
				if(temp.getTitle().equals(link.getTitle())){
					return alerts;
				}
				temp.setUrl(e.getElementsByTag("a").get(0).attr("href"));
				temp.setImg(e.getElementsByTag("img").get(0).attr("src"));
				temp.setAlerttime(e.getElementsByTag("time").get(0).html());
				temp.setDesc1(e.getElementsByClass("note").get(0).html());
				temp.setAtypeId(link.getTypeid());
				temp.setResLinkId(link.getId());
				temp.setResId(link.getResid());
				
				crawlerAlert(temp);
				
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
			Element content = document.getElementsByClass("article-entry").get(0);
			if(content.getElementsByTag("p").get(0).html().indexOf("转载请看清文末的转载要求")>0){
				content.getElementsByTag("p").get(0).remove();
			}
			content.select("script").remove();
			alert.setContent("<div class=\"article-entry\">"+content.html()+"</div>");
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
