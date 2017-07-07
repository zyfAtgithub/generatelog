package com.jshx.generatelog.random;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RandomDate {

	/**
	 * 随机生成指定范围内的日期
	 * @param maxDateVal
	 * @param minDateVal
	 * @return
	 */
	public static String randomDateBetweenMinAndMax(int[] maxDateVal, int[] minDateVal){  
	       Calendar calendar = Calendar.getInstance();  
	       //注意月份要减去1  
	       calendar.set(minDateVal[0],minDateVal[1],minDateVal[2], minDateVal[3], minDateVal[4], minDateVal[5]);  
	       calendar.getTime().getTime();  
	       long min = calendar.getTime().getTime();;  
	       calendar.set(maxDateVal[0],maxDateVal[1],maxDateVal[2], maxDateVal[3], maxDateVal[4], maxDateVal[5]);  
	       calendar.getTime().getTime();  
	       long max = calendar.getTime().getTime();  
	       //得到大于等于min小于max的double值  
	       double randomDate = Math.random()*(max-min)+min;  
	       //将double值舍入为整数，转化成long类型  
	       calendar.setTimeInMillis(Math.round(randomDate));  
	       Date d = calendar.getTime();
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	       return sdf.format(d);  
	   }  
	
	public static void main(String[] args) {
		int[] maxDateVal = {2017,6,7,18,00,22};
		int[] minDateVal = {2017,6,8,02,00,00};
		String str = randomDateBetweenMinAndMax(maxDateVal, minDateVal);
		System.out.println(str);
	}

}
