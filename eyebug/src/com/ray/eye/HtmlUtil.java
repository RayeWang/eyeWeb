package com.ray.eye;
/**
 * Html 工具类
 * @author Ray Wang
 * @date 2015年5月22日14:59:28
 */
public class HtmlUtil {

	/**
	 * 对HTML的转义过的符号转义回来
	 * @param res 网页内容
	 * @return
	 */
	public synchronized static String encode(String res){
		res = res.replace("&lt;", "<");
		res = res.replace("&quot;", "\"");
		res = res.replace("&amp;", "&");
		res = res.replace("&gt;", ">");
		res = res.replace("noscript", "p");
		return res;
	}
}
