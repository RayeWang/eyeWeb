package com.ray.eye;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;

public class Test {

	public static void main(String[] args) {
		Crawler crawler = new CodeceoCrawler();
		
		Alert alert = new Alert();
		ResLink link = new ResLink();
		link.setUrl("http://www.codeceo.com/article/category/develop");
		crawler.crawlerList(link);
	}
}
