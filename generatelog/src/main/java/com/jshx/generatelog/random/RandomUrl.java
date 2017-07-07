package com.jshx.generatelog.random;

import java.util.Random;

import com.jshx.generatelog.util.StringUtils;

public class RandomUrl {

	private static final String[] DOMAIN_MANE = { "ltetp3.tv189", "vod.yanhua.ctlcdn.com", "vod.cibn.ctlcdn.com" };

	public static String getRandomUrl() {
		Random random = new Random(); 
		String domain = DOMAIN_MANE[random.nextInt(DOMAIN_MANE.length)];
		int subLinks = random.nextInt(6);
		StringBuffer sub = new StringBuffer("");
		for (int i = 0; i <= subLinks; i++) {
			String randStr = getRandomString(random.nextInt(20));
			if (!StringUtils.isNullOrEmpty(randStr)) {
				sub.append("/").append(randStr);
			}
		}
		return "http://" + domain + sub.toString();
	}
	
	private static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    
	    return sb.toString();     
	 }     
	
	public static void main(String[] args) {
		System.out.println(getRandomUrl());
	}

}
