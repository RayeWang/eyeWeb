package com.ray.entity.mapper;
/**
 * 为了执行动态SQL的类
 * @author Ray Wang
 * @date 2015年5月17日15:12:40
 * @version 1.0
 */
public class DynamicSql {

	private static final ThreadLocal<String> sql = new ThreadLocal<String>();
	
	public void setSql(String sql){
		this.sql.set(sql);
	}
	
	public String getSql(){
		return this.sql.get();
	}
}
