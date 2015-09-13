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
 * InfoQ的文章爬取实现类
 * @author Ray Wang
 * @date 2015年5月20日10:14:19
 * @version 1.0
 */
public class InfoqAlert implements Crawler {
	
	/** 用于工厂判断使用哪个类来实现的主要是看看在网站改版后，只更新爬虫的jar能不能使用*/
	public static final String NOWURL = "http://www.infoq.com/cn/articles";

	public ArrayList<Alert> crawlerList(ResLink link) {
		ArrayList<Alert> list = new ArrayList<Alert>();
		
		try {
			URL url = new URL(link.getUrl());
			Document document = Jsoup.parse(url,TIMEOUT);
			Elements es = document.getElementsByClass("news_type1");
			
			for(int i = 0;i < es.size();i++){
				Alert q = new Alert();
				Element temp = es.get(i);
				
				q.setTitle(temp.getElementsByTag("a").get(0).html());
				if(q.getTitle().equals(link.getTitle())){
					//已经爬取过这条了
					return list;
				}
				//移除时间里面的<a>标签
				temp.getElementsByClass("author").get(0).select("a").remove();
				
				String time = temp.getElementsByClass("author").get(0).html();
				q.setAlerttime(time.substring(time.indexOf("发布于")+3));
				q.setImg(temp.getElementsByTag("p").get(0).getElementsByTag("img").attr("src"));
				//移除描述里面的<a>标签
				temp.getElementsByTag("p").get(0).select("a").remove();
				q.setDesc1(temp.getElementsByTag("p").get(0).html());
				
				q.setAtypeId(link.getTypeid());
				q.setResLinkId(link.getId());
				q.setResId(link.getResid());
				//获取类容
				q.setUrl("http://www.infoq.com"+
						temp.getElementsByTag("a").get(0).attr("href"));
				
				crawlerAlert(q);
				
				list.add(q);
			}
			
			
			Elements es1 = document.getElementsByClass("news_type2");
			
			for(int i = 0;i < es1.size();i++){
				Alert q = new Alert();
				Element temp = es1.get(i);
				
				q.setTitle(temp.getElementsByTag("a").get(0).html());
				if(q.getTitle().equals(link.getTitle())){
					//已经爬取过这条了
					return list;
				}
				
				//移除时间里面的<a>标签
				temp.getElementsByClass("author").get(0).select("a").remove();
				
				String time = temp.getElementsByClass("author").get(0).html();
				q.setAlerttime(time.substring(time.indexOf("发布于")+3));
				
				q.setImg(temp.getElementsByClass("pic").get(0).getElementsByTag("img").attr("src"));
				temp.getElementsByTag("p").get(0).select("a").remove();
				q.setDesc1(temp.getElementsByTag("p").get(0).html());
				
				q.setAtypeId(link.getTypeid());
				q.setResLinkId(link.getId());
				q.setResId(link.getResid());
				//获取类容
				q.setUrl("http://www.infoq.com"+
						temp.getElementsByTag("a").get(0).attr("href"));
				
				crawlerAlert(q);
				
				list.add(q);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean crawlerAlert(Alert alert) {
		try {
			//暂停2秒
			Thread.sleep(60000);
			URL url = new URL(alert.getUrl());
			Document document = Jsoup.parse(url, TIMEOUT);
			Element element = document.getElementsByClass("text_info").first();
			element.select("related_sponsors").remove();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < element.childNodeSize();i++){
				Node node = element.childNode(i);
				
				if(node.attr("class").equals("related_sponsors visible stacked")){
					continue;
				}
				if(node.attr("class").equals("random_links")){
					break;
				}
				String temp = node.outerHtml();
				if(temp.indexOf("给InfoQ中文站投稿或者参与内容翻译工作，请邮件至") >= 0){
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
