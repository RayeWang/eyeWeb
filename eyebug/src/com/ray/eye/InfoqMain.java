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
import org.springframework.stereotype.Service;

import com.ray.entity.Alert;
/**
 * InfoQ����ȥ����
 * @author Ray Wang
 * @date 2015��5��16��23:03:11
 * @version 1.0
 */
@Service("InfoqMain")
public class InfoqMain {

	/**
	 * ��ȡ����
	 * @param urlstr
	 * @return
	 */
	public static String infoqwz(String urlstr){
		try {
			URL url = new URL(urlstr);
			Document document = Jsoup.parse(url, 10000);
			Element element = document.getElementsByClass("text_info").first();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < element.childNodeSize();i++){
				Node node = element.childNode(i);
				if(node.outerHtml().indexOf("��InfoQ����վͶ����߲���") >= 0){
					break;
				}
				if(node.attr("class").equals("related_sponsors visible stacked")){
					continue;
				}
				if(node.attr("class").equals("random_links")){
					break;
				}
				sb.append(element.childNode(i).outerHtml());
			}
			
			return sb.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	public static ArrayList<Alert> infoqArticle(){
		ArrayList<Alert> list = new ArrayList<Alert>();
		
		try {
			URL url = new URL("http://www.infoq.com/cn/articles");
			Document document = Jsoup.parse(url,10000);
			Elements es = document.getElementsByClass("news_type1");
			
			for(int i = 0;i < es.size();i++){
				Alert q = new Alert();
				Element temp = es.get(i);
				
				q.setTitle(temp.getElementsByTag("a").get(0).html());
				//�Ƴ�ʱ�������<a>��ǩ
				temp.getElementsByClass("author").get(0).select("a").remove();
				
				String time = temp.getElementsByClass("author").get(0).html();
				q.setAlerttime(time.substring(time.indexOf("������")+3));
				q.setImg(temp.getElementsByTag("p").get(0).getElementsByTag("img").attr("src"));
				//�Ƴ����������<a>��ǩ
				temp.getElementsByTag("p").get(0).select("a").remove();
				q.setDesc1(temp.getElementsByTag("p").get(0).html());
				q.setAtypeId(1);
				q.setResLinkId(1);
				q.setResId(1);
				//��ȡ����
				q.setContent(infoqwz("http://www.infoq.com"+
						temp.getElementsByTag("a").get(0).attr("href")));
				q.setUrl("http://www.infoq.com"+
						temp.getElementsByTag("a").get(0).attr("href"));
				list.add(q);
			}
			
			
			Elements es1 = document.getElementsByClass("news_type2");
			
			for(int i = 0;i < es1.size();i++){
				Alert q = new Alert();
				Element temp = es1.get(i);
				
				q.setTitle(temp.getElementsByTag("a").get(0).html());
				//�Ƴ�ʱ�������<a>��ǩ
				temp.getElementsByClass("author").get(0).select("a").remove();
				
				String time = temp.getElementsByClass("author").get(0).html();
				q.setAlerttime(time.substring(time.indexOf("������")+3));
				
				q.setImg(temp.getElementsByClass("pic").get(0).getElementsByTag("img").attr("src"));
				temp.getElementsByTag("p").get(0).select("a").remove();
				q.setDesc1(temp.getElementsByTag("p").get(0).html());
				q.setAtypeId(1);
				q.setResId(1);
				q.setResLinkId(1);
				//��ȡ����
				q.setContent(infoqwz("http://www.infoq.com"+
						temp.getElementsByTag("a").get(0).attr("href")));
				q.setUrl("http://www.infoq.com"+
						temp.getElementsByTag("a").get(0).attr("href"));
				list.add(q);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
