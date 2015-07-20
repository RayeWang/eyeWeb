package com.ray.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ray.controller.AppController;

@Component
public class APPTask {

	@Scheduled(cron="0 59 23 ? * * ")
	public void task(){
		AppController.count = 0;
	}
}
