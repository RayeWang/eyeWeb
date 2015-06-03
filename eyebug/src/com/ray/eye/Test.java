package com.ray.eye;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;

public class Test {

	public static void main(String[] args) {
//		Crawler crawler = new CodeceoCrawler();
//		
//		Alert alert = new Alert();
//		ResLink link = new ResLink();
//		link.setUrl("http://www.codeceo.com/article/category/develop");
//		crawler.crawlerList(link);
		
		try {
			URL url = new URL("http://www.vegnet.com.cn/Price/List_ar330000_p1.html?marketID=307");
			Document document = Jsoup.parse(url, 100000);
			System.out.println(document.html());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
