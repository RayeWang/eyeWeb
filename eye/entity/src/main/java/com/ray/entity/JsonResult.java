package com.ray.entity;
/**
 * 返回的json对象
 * @author Ray
 * @date 2015年6月25日15:25:11
 * @version 1.0
 */
public class JsonResult {

	private String errcode;
	private String errmsg;
	private Object data;
	
	
	public JsonResult() {
		super();
	}
	public JsonResult(Object data) {
		super();
		this.data = data;
	}
	public JsonResult(String errcode, String errmsg) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
