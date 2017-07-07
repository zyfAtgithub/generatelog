package com.jshx.generatelog;

import java.util.Random;

import com.jshx.generatelog.constants.Constants;
import com.jshx.generatelog.random.RandomDate;
import com.jshx.generatelog.random.RandomIp;
import com.jshx.generatelog.random.RandomUrl;
import com.jshx.generatelog.util.FileUtil;

/**
 * 日志生成
 * @author zyf
 *
 */
public class AccessLogWriter {

	public static String generateRecord() {
		Random random = new Random();
		String srcIp = RandomIp.getRandomIP("48.23.87.12", "69.22.12.4");
		String desIp = RandomIp.getRandomIP("228.12.97.81", "232.12.3.99");
		int[] maxDateVal = {2016,5,7,00,00,22};
		int[] minDateVal = {2017,6,8,00,00,00};
		String reqTime = RandomDate.randomDateBetweenMinAndMax(maxDateVal, minDateVal);
		String reqMethod = Constants.REQUEST_METHOD[random.nextInt(Constants.REQUEST_METHOD.length)];
		String url = RandomUrl.getRandomUrl();
		String httpCode = Constants.HTTP_CODE[random.nextInt(Constants.HTTP_CODE.length)];
		String flux = random.nextInt(100000) + "";
		String from = "-";
		String cost = random.nextInt(1000) + "";
		String qualityCode = "-";
		if (random.nextInt(2) == 1) {
			qualityCode = random.nextInt(2000) + "";
		}
		String ua = Constants.UA[random.nextInt(Constants.UA.length)];
		
		StringBuffer record = new StringBuffer("");
		record.append(srcIp).append(" ").append(desIp).append(" ")
		.append(reqTime).append(" ").append(reqMethod).append(" ")
		.append(url);
		if (!"-".equals(qualityCode)) {
			record.append("?qualityCode=").append(qualityCode);
		}
		record.append(" ").append(Constants.PROTOCOL).append(" ")
		.append(httpCode).append(" ").append(flux).append(" ")
		.append(from).append(" ").append(cost).append(" ")
		.append(qualityCode).append(" ").append(ua);
		return record.toString();
	}
	
	public static void main(String[] args) {
		
		if (args == null || args.length == 0) {
			System.err.println("请输入休眠时间！");;
		}
		
		System.out.println("begin!");
		
		int sleepTime = Integer.valueOf(args[0]);
		
		while(true) {
			FileUtil.appentContent2File(Constants.ACCESSLOG_PATH, generateRecord());
			try {
				//每次写完，休眠30ms
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
