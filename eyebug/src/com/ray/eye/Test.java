package com.ray.eye;

import com.ray.entity.Alert;

public class Test {

	public static void main(String[] args) {
		FreebufCrawler crawler = new FreebufCrawler();
		
		Alert alert = new Alert();
		alert.setUrl("http://www.freebuf.com/articles/web/68002.html");
		crawler.crawlerAlert(alert);
	}
}
