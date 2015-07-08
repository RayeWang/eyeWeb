package com.ray.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ray.controller.AppController;

@Component
public class APPTask {

	@Scheduled(cron="0 30 17 ? * * ")
	public void task(){
		System.out.println("count is 0");
		AppController.count = 0;
	}
}
