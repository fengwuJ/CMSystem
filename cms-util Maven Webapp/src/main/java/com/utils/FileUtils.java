package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;


//负责上传和下载文件
public class FileUtils {
	//创建目录,返回目录路径,url为static/*
	public static String createDir(String url) {
		String fileUrl = null;
		File path = null;
		try {
			path = new File(ResourceUtils.getURL("classpath:").getPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File upload = new File(path.getAbsolutePath(),"static"+File.separator+url);
		if(!upload.exists()){
			upload.mkdirs();
		}
		fileUrl = upload.getAbsolutePath();
		return fileUrl;
	}
	
	//写入文件
	/**
	 * 
	 * @param path  上传文件的当前目录
	 * @param file	 要上传的文件
	 * @return		文件上传成功，数据库更新成功
	 */
	public static boolean writeIntoFile(String path,MultipartFile file){
		//获取文件名,包括后缀
		String fileName = file.getOriginalFilename();
		//拼接文件绝对路径
		File tagetFile = new File(path+File.separator+fileName);
		try {
			//写入文件
			file.transferTo(tagetFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean writeIntoCourseFile(String path,MultipartFile file){
		File dirFile = new File(path);
		//判断是否有文件
		File[] fs = dirFile.listFiles();
		if(fs != null){
			for (File f : fs) {
				//若是文件，则将其删除
				if (!f.isDirectory()) {
					f.delete();
				}
			}
		}
		//获取文件名,包括后缀
		String fileName = file.getOriginalFilename();
		//拼接文件绝对路径
		File tagetFile = new File(path+File.separator+fileName);
		try {
			//写入文件
			file.transferTo(tagetFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 
	 * @param url 文件的绝对路径
	 * @param response	响应信息
	 */
	public static void downloadFile(String url, HttpServletResponse response) {
		// TODO Auto-generated method stub
		File file = new File(url);
		String[] temp = url.split(File.separator+File.separator);
		String fileName = temp[temp.length-1];
		FileInputStream fis = null;
		if (file.exists()) {
			try {
				response.reset();
				response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes(),"iso-8859-1"));
				response.setContentType("application/octet-stream; charset=utf-8");
				fis =  new FileInputStream(file);
				byte[] buffer = new byte[128];
		        int count = 0;
		        while ((count = fis.read(buffer)) > 0) {
		            response.getOutputStream().write(buffer, 0, count);
		        }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					response.getOutputStream().flush();
					response.getOutputStream().close();
			        if (fis != null) {
			        	fis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			}
		}
	}

	public static void getPdF(Map<String, Object> map, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
