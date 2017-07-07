package com.jshx.generatelog.util;

/**
 * String工具类
 * @author zyf
 *
 */
public class StringUtils {

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	public static boolean isNotNullAndEmpty(String str) {
		return !isNullOrEmpty(str);
	}
}
