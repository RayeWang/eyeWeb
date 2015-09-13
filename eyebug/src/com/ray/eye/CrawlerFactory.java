package com.ray.eye;

import java.util.ArrayList;

import com.ray.entity.Alert;
import com.ray.entity.ResLink;
/**
 * ���湤����
 * @author Ray Wang
 * @date 2015��5��20��11:16:01
 * @version 1.0
 */
public class CrawlerFactory {

	/**
	 * ���ݲ�ͬ��URL������ͬ��������
	 * @param link ������Դ����
	 * @return ���¼���
	 */
	public ArrayList<Alert> crawlerFactory(ResLink link){
		Crawler crawler = null;
		
		if(link.getUrl().equals(InfoqAlert.NOWURL)){
			crawler = new InfoqAlert();
		}else if(link.getUrl().equals(InfoqNew.NOWURL)){
			crawler = new InfoqNew();
		}else if(link.getUrl().equals(FreebufCrawler.NOWURL)){
			crawler = new FreebufCrawler();
		}else if(link.getUrl().equals(CodeceoCrawler.NOWURL)){
			crawler = new CodeceoCrawler();
		}else if(link.getUrl().equals(CodeceoProgrammerCrawler.NOWURL)){
			crawler = new CodeceoProgrammerCrawler();
		}
		
		if(crawler == null){
			return null;
		}
		return crawler.crawlerList(link);
	}
}
