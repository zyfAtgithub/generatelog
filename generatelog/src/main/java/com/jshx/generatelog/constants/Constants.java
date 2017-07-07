package com.jshx.generatelog.constants;

public final class Constants {

	/**
	 * 访问日志路径
	 */
	public static String ACCESSLOG_PATH = "/local/akazam/servers/nginx_log/access.log";
//	public static String ACCESSLOG_PATH = "d://logs//access.log";
	
	/**
	 * 日志文件大小阀值（G）
	 */
	public static long FILESIZE_THRESHOLD = 2 * 1024 * 1024 * 1024l;
	
	/**
	 * HTTP状态码
	 */
	public static final String[] HTTP_CODE = {"200", "302", "403" ,"400", "404", "500"};
	
	/**
	 * 协议
	 */
	public static final String PROTOCOL = "HTTP/1.1";
	
	/**
	 * 请求方式
	 */
	public static final String[] REQUEST_METHOD = {"POST", "GET"};
	
	/**
	 * 客户端（UA）
	 */
	public static final String[] UA = {
			"TYSX-PLAYER-1.0.10",
//			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E; HCTE; rv:11.0) like Gecko",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2", 
//			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36", 
//			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.71 Safari/537.1 LBBROWSER",
//			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E)",
//			"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.84 Safari/535.11 SE 2.X MetaSr 1.0",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 UBrowser/4.0.3214.0 Safari/537.36",
//			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.4.3.4000 Chrome/30.0.1599.101 Safari/537.36", 
//			"Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5"
	};
}
