package com.jshx.generatelog.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jshx.generatelog.constants.Constants;

/**
 * 文件工具类
 * @author zyf
 *
 */
public class FileUtil {

	/**
	 * 根据所给路径判断文件的存在性
	 * @param fileAbsPath
	 * @return
	 */
	private static boolean judgeFileExist(String fileAbsPath) {
		if (StringUtils.isNullOrEmpty(fileAbsPath)) {
			return false;
		}
		return new File(fileAbsPath).exists();
	}
	
	/**
	 * 生成文件
	 * @param fileAbsPath
	 * @return
	 */
	private static void generateFile(String fileAbsPath) {
		
		if (judgeFileExist(fileAbsPath)) {
			return;
		}
		
		String pdirPath = fileAbsPath.substring(0,fileAbsPath.lastIndexOf(File.separator) + 1);
		System.out.println("pdirPath:" + pdirPath);
		if (!judgeFileExist(pdirPath)) {
			File pdir = new File(pdirPath);
			boolean b = pdir.mkdirs();
			if (!b) {
				return;
			}
		}

		File f = new File(fileAbsPath);
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 文件重命名
	 * @param fileAbsPath
	 * @return
	 */
	private static boolean renameFile(String fileAbsPath) {
		if (!judgeFileExist(fileAbsPath)) {
			//文件不存在，重命名失败
			return false;
		}
		
		String pdirPath = fileAbsPath.substring(0,fileAbsPath.lastIndexOf(File.separator) + 1);
		String fileName = fileAbsPath.substring(fileAbsPath.lastIndexOf(File.separator)  + 1);
	
		//使用时分秒命名
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String newName = pdirPath + fileName.substring(0, fileName.lastIndexOf(".")) + sf.format(new Date()) + fileName.substring(fileName.lastIndexOf("."));
		File f = new File(fileAbsPath);
		File newF = new File(newName);
		return f.renameTo(newF);
	}
	
	
	/**
	 * 写文件
	 * @param fileName
	 * @param content
	 */
	public static boolean appentContent2File(String fileName, String content) {
		//文件对应目录不存在就创建
		generateFile(fileName);
		
		RandomAccessFile randomFile = null;
		try {
			// 打开一个随机访问文件流，按读写方式
			randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			//文件大小超出限制
			if (fileLength + content.getBytes().length + 2 >= Constants.FILESIZE_THRESHOLD) {
				System.out.println("文件大小到达上限！！");
				if (randomFile != null) {
					try {
						randomFile.close();
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				}
				renameFile(fileName);
				return true;
			}
			
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content + "\r\n");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		renameFile(Constants.ACCESSLOG_PATH);

	}
}
