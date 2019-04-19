package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.entity.course.CourseInfo;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.ExamSingleChoice;
import com.entity.userInfo.TeacherInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


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

	public static void getPdF(String examName,Map<String, Object> map, HttpServletResponse response) throws DocumentException, IOException {
		TeacherInfo teacherInfo = (TeacherInfo) map.get("teacherInfo");
		CourseInfo courseInfo = (CourseInfo) map.get("courseInfo");
		List<ExamSingleChoice> examSingleChoiceList = (List<ExamSingleChoice>) map.get("examSingleChoiceList");
		List<ExamShortAnswer> examShortAnswerList = (List<ExamShortAnswer>) map.get("examShortAnswerList");

		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

		Font headfont = new Font(bfChinese, 12, Font.BOLD);
		Font secheadfont = new Font(bfChinese, 12, Font.BOLD);
		Font gradefont = new Font(bfChinese, 12, Font.BOLD);
		Font titleFont = new Font(bfChinese,12,Font.BOLD);
		Font textfont = new Font(bfChinese, 12, Font.NORMAL);

		String kecheng = "课程："+courseInfo.getName();
		String chutiren = "出题人:"+teacherInfo.getName();
		String defen = "得分:_____";
		String name = "姓名:__________";
		String number = "学号:__________";
		String classnum = "班级:__________";
		String zhuanye = "专业：__________";
		String xuanzeti = "一、选择题";
		String jiandati = "二、简答题";
		
		String fileName = examName+".pdf";
		
		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));

		// 打开文档
		document.open();

		// 设置标题
		Paragraph header1 = new Paragraph(examName, headfont);
		header1.setAlignment(Element.ALIGN_CENTER);
		document.add(header1);

		// table1
		PdfPTable table1 = new PdfPTable(3);
		table1.setSpacingBefore(25);
		//int width1[] = { 70, 30 };
		//table1.setWidths(width1);
		table1.getDefaultCell().setBorder(0);
		PdfPCell cell1 = new PdfPCell(new Paragraph(kecheng, gradefont));
		cell1.setBorder(0);
		PdfPCell cell2 = new PdfPCell(new Paragraph(chutiren, gradefont));
		cell2.setBorder(0);
		PdfPCell cell3 = new PdfPCell(new Paragraph(defen, gradefont));
		cell3.setBorder(0);
		table1.addCell(cell1);
		table1.addCell(cell2);
		table1.addCell(cell3);
		document.add(table1);

		// table2 学生信息
		PdfPTable table2 = new PdfPTable(4);
		table2.setWidthPercentage(100); // 宽度100%填充
		table2.setSpacingBefore(10f); // 前间距
		table2.setSpacingAfter(10f); // 后间距
		//int width2[] = { 50, 50 };
		//table2.setWidths(width2);
		table2.setSpacingBefore(30);

		PdfPCell cell21 = new PdfPCell(new Paragraph(number, textfont));
		cell21.setPaddingTop(10);
		cell21.setPaddingBottom(10);
		cell21.setBorder(0);
		PdfPCell cell22 = new PdfPCell(new Paragraph(name, textfont));
		cell22.setPaddingTop(10);
		cell22.setPaddingBottom(10);
		cell22.setBorder(0);
		PdfPCell cell23 = new PdfPCell(new Paragraph(classnum, textfont));
		cell23.setPaddingTop(10);
		cell23.setPaddingBottom(10);
		cell23.setBorder(0);
		PdfPCell cell24 = new PdfPCell(new Paragraph(zhuanye, textfont));
		cell24.setPaddingTop(10);
		cell24.setPaddingBottom(10);
		cell24.setBorder(0);
		table2.addCell(cell21);
		table2.addCell(cell22);
		table2.addCell(cell23);
		table2.addCell(cell24);
		document.add(table2);

		// table3 选择题
		PdfPTable scTitleTable = new PdfPTable(1);
		scTitleTable.setSpacingBefore(30);
		PdfPCell scCell = new PdfPCell(new Paragraph(xuanzeti, titleFont));
		scCell.setPaddingBottom(20);
		scCell.setPaddingTop(20);
		scCell.setBorder(0);
		scTitleTable.addCell(scCell);
		document.add(scTitleTable);
		
		//table3 选择题内容
		for(int i = 0; i < examSingleChoiceList.size(); i++){
			PdfPTable scTitleContent = new PdfPTable(1);
			scTitleContent.setSpacingBefore(25);
			PdfPCell cellTitle = new PdfPCell(new Paragraph((i+1)+"、"+examSingleChoiceList.get(i).getTitle()+"\t\t\t\t(   )", textfont));
			PdfPCell cellAOption = new PdfPCell(new Paragraph("A、"+examSingleChoiceList.get(i).getaOption(), textfont));
			PdfPCell cellBOption = new PdfPCell(new Paragraph("B、"+examSingleChoiceList.get(i).getbOption(), textfont));
			PdfPCell cellCOption = new PdfPCell(new Paragraph("C、"+examSingleChoiceList.get(i).getcOption(), textfont));
			PdfPCell cellDOption = new PdfPCell(new Paragraph("D、"+examSingleChoiceList.get(i).getdOption(), textfont));
			
			cellTitle.setPaddingLeft(5);
			cellTitle.setPaddingTop(5);
			
			cellAOption.setPaddingLeft(5);
			cellAOption.setPaddingTop(5);
			
			cellBOption.setPaddingLeft(5);
			cellBOption.setPaddingTop(5);
			
			cellCOption.setPaddingLeft(5);
			cellCOption.setPaddingTop(5);
			
			cellDOption.setPaddingLeft(5);
			cellDOption.setPaddingTop(5);
			
			cellTitle.setBorder(0);
			cellAOption.setBorder(0);
			cellBOption.setBorder(0);
			cellCOption.setBorder(0);
			cellDOption.setBorder(0);
			
			scTitleContent.addCell(cellTitle);
			scTitleContent.addCell(cellAOption);
			scTitleContent.addCell(cellBOption);
			scTitleContent.addCell(cellCOption);
			scTitleContent.addCell(cellDOption);
			
			document.add(scTitleContent);
		}

		// table4 简答题标题
		PdfPTable saTitleTable = new PdfPTable(1);
		PdfPCell saCell = new PdfPCell(new Paragraph(jiandati, titleFont));
		saCell.setPaddingTop(60);
		saCell.setPaddingBottom(30);
		saCell.setBorder(0);
		saTitleTable.addCell(saCell);
		document.add(saTitleTable);

		//简答题内容
		for(int i = 0; i < examShortAnswerList.size(); i++){
			PdfPTable saTable = new PdfPTable(1);
			saTable.setSpacingAfter(60);
			//题目
			PdfPCell cellTitle = new PdfPCell(new Paragraph((i+1)+"、"+examShortAnswerList.get(i).getTitle(), textfont));
			cellTitle.setPaddingLeft(5);
			cellTitle.setBorder(0);
			
			saTable.addCell(cellTitle);
			document.add(saTable);
		}
		

		
		// 标准答案
		document.newPage();
		Paragraph header2 = new Paragraph("标准答案", headfont);
		header2.setAlignment(Element.ALIGN_CENTER);
		document.add(header2);
		
		//选择题标准答案
		PdfPTable singleChoiceT = new PdfPTable(1);
		singleChoiceT.setSpacingBefore(20);
		PdfPCell xztCell = new PdfPCell(new Paragraph("一、选择题", titleFont));
		xztCell.setPaddingTop(20);
		xztCell.setBorder(0);
		singleChoiceT.addCell(xztCell);
		document.add(singleChoiceT);
		
		PdfPTable scSASTable = new PdfPTable(examSingleChoiceList.size());
		scSASTable.setSpacingBefore(10);
		for (int i = 0; i < examSingleChoiceList.size(); i++) {
			PdfPCell cell = new PdfPCell(new Paragraph((i+1)+"、"+examSingleChoiceList.get(i).getRightChoice(), textfont));
			scSASTable.addCell(cell);
		}
		document.add(scSASTable);
		
		
		//简答题标准答案
		PdfPTable shortAnswerT = new PdfPTable(1);
		shortAnswerT.setSpacingBefore(20);
		shortAnswerT.setSpacingAfter(20);
		PdfPCell jdtCell = new PdfPCell(new Paragraph("二、简答题", titleFont));
		jdtCell.setPaddingTop(20);
		jdtCell.setBorder(0);
		shortAnswerT.addCell(jdtCell);
		document.add(shortAnswerT);
		
		PdfPTable saSASTable = new PdfPTable(1);
		saSASTable.setSpacingBefore(10);
		for (int i = 0; i < examShortAnswerList.size(); i++) {
			PdfPCell cell = new PdfPCell(new Paragraph((i+1)+"、"+examShortAnswerList.get(i).getAnswer(), textfont));
			cell.setBorder(0);
			cell.setPaddingBottom(20);
			saSASTable.addCell(cell);
		}
		document.add(saSASTable);

		// 关闭文档
		document.close();

		writer.close();
		
		//向前端写出文件
		File file = new File(fileName);
		if (file.exists()) {
			FileInputStream fis = null;
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
}
