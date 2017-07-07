package com.jshx.generatelog.random;

import java.util.Random;

/**
 * 产生随机ip地址
 * @author zyf
 *	利用加权平均来处理。
 *	简单来说就是对于a.b.c.d的IP地址：
 *	Sum = a*256*256*256+b*256*256+c*256+d的值是唯一的，而且递增的。
 *	解码的话：
 *	d = Sum % 256;
 *	c = (Sum % (256*256) - d) / 256;
 *	b = (Sum % (256*256*256) - d - c*256) / (256*256);
 *	a = Sum / (256*256*256);
 */
public class RandomIp {

	
	public static String getRandomIP(String firstIP, String endIP)
    {
		//支持边界，1%的概率
		int bound = generateSection();
		if (bound == 0) {
			return firstIP;
		}
		if (bound == 2) {
			return endIP;
		}
		String[] firstIPList = firstIP.split("\\.");
		String[] endIPList = endIP.split("\\.");

        long min = Long.parseLong(firstIPList[0]) * 256 * 256 * 256 + Long.parseLong(firstIPList[1]) * 256 * 256 + Long.parseLong(firstIPList[2]) * 256 + Long.parseLong(firstIPList[3]);
        long max = Long.parseLong(endIPList[0]) * 256 * 256 * 256 + Long.parseLong(endIPList[1]) * 256 * 256 + Long.parseLong(endIPList[2]) * 256 + Long.parseLong(endIPList[3]);
        long diff = (((long) (new Random().nextDouble() * (max - min)))) + min;
        long d = diff % 256;
        long c = (diff % (256 * 256) - d) / 256;
        long b = (diff % (256 * 256 * 256) - d - c * 256) / (256 * 256);
        long a = diff / (256 * 256 * 256);
        String ip = a + "." + b + "." + c + "." + d;
        return ip;
    }
	
	/**
	 * 边界确定
	 * @return
	 */
	private static int generateSection() {
		Random r = new Random();
		int rval = r.nextInt(100);
		int bound = 1; //结果数字
		if (rval < 2) {//[0,2) %1几率
			bound = 0;
		}
		else if(rval <= 98){ //[2,98] 区间，98%的几率
			bound = 1;
		}else {//(98,100]，1%的几率
			bound = 2;
		}
		return bound;
	}
	
	public static void main(String[] args) {
		String ip = getRandomIP("192.16.3.1", "192.168.3.30");
		System.out.println(ip);
	}

}
