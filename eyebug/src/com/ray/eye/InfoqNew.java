package com.ray.eye;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;
/**
 * InfoQ的新闻爬取类
 * @author Ray Wang
 * @date 2015年5月20日10:34:38
 * @version 1.0
 */
public class InfoqNew implements Crawler {

	/** 用于工厂判断使用哪个类来实现的主要是看看在网站改版后，只更新爬虫的jar能不能使用*/
	public static final String NOWURL = "http://www.infoq.com/cn/news";
	
	public ArrayList<Alert> crawlerList(ResLink link) {
		ArrayList<Alert> alert = new ArrayList<Alert>();
		try {
			URL url = new URL(link.getUrl());
			Document document = Jsoup.parse(url, TIMEOUT);
			//获取所有文章的div
			Elements elements = document.getElementsByClass("news_type_block");
			
			for(int i = 0;i < elements.size();i++){
				Element e = elements.get(i);
				Alert temp = new Alert();
				
				temp.setTitle(e.getElementsByTag("a").get(0).html());
				if(temp.getTitle().equals(link.getTitle())){
					return alert;
				}
				e.getElementsByClass("author").select("a").remove();
				String time = e.getElementsByClass("author").get(0).html();
				temp.setAlerttime(time.substring(time.indexOf("发布于")+3));
				
				temp.setDesc1(e.getElementsByTag("p").html());
				
				temp.setAtypeId(link.getTypeid());
				temp.setResLinkId(link.getId());
				temp.setResId(link.getResid());
				//获取内容
				temp.setUrl("http://www.infoq.com"+
						e.getElementsByTag("a").get(0).attr("href"));
				
				crawlerAlert(temp);
				alert.add(temp);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alert;
	}

	public boolean crawlerAlert(Alert alert) {
		try {
			URL url = new URL(alert.getUrl());
			Document document = Jsoup.parse(url, TIMEOUT);
			Element element = document.getElementsByClass("text_info").first();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < element.childNodeSize();i++){
				Node node = element.childNode(i);
				if(node.attr("class").equals("related_sponsors visible stacked")){
					continue;
				}
				if(node.attr("class").equals("random_links")){
					break;
				}
				sb.append(element.childNode(i).outerHtml());
			}
			alert.setContent(sb.toString());
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
