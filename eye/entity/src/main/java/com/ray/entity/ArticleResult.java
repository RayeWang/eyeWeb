package com.ray.entity;

/**
 * 文章的json返回对象
 * @author Ray
 * @date 2015年6月25日15:26:35
 * @version 1.0
 */
public class ArticleResult extends JsonResult{

	private int count;
	
	public ArticleResult() {
		super();
	}

	public ArticleResult(String errcode,String errmsg){
		super(errcode,errmsg);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
