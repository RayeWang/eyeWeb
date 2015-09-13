package com.ray.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 进行加密的工具类
 * @author Ray
 * @date 2014年11月28日15:30:06
 * @version 1.0
 */
public class MD5Util {

	public static String byteArrayHex(byte[] b){
		
		//将数组转为16进制字符串
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < b.length ; i++){
			String hex = Integer.toHexString(b[i] & 0xFF); 
            if (hex.length() == 1) { 
                hex = '0' + hex; 
            } 
            sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	
	
	public static String md5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] inputByte;
			byte[] outputByte;
			
			inputByte = str.getBytes("utf-8");
			outputByte = md.digest(inputByte);
			
			String strs = byteArrayHex(outputByte);
			return strs;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}