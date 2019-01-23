package com.controller.teacher.course;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.course.CourseFile;
import com.mapper.teacher.course.TeachCourseFileMapper;
import com.service.serviceInterface.teacher.course.SearchCourseFileServiceInf;
import com.utils.FileUtils;

@Controller
@RequestMapping("/static/teacherview/mCourse")
public class TeachCourseController {
	@Resource(name="scfsImpl")
	private SearchCourseFileServiceInf scfsInf;
	
	@Resource
	private TeachCourseFileMapper tcfMapper;
	
	@RequestMapping("/searchCourseFile")
	@ResponseBody
	public Map<String, Object> searchCourseFile(String tid,String cid){
		Map<String, Object> map = new HashMap<String, Object>();
		CourseFile courseFile = scfsInf.searchCourseFile(tid,cid);
		map.put("courseFile", courseFile);
		return map;
	}
	
	@RequestMapping("/uploadCourseFile")
	@ResponseBody
	public String uploadCourseFile(@RequestParam(value = "file", required = false)MultipartFile file,String cid,String tid){
		String result = scfsInf.uploadCourseFile(tid,cid,file);
		return result;
	}
	
	@RequestMapping("/checkCFileExsist")
	@ResponseBody
	public String checkCFileExsist(String tid,String cid,String fileName) {
		String result = scfsInf.checkCFileExsist(tid,cid,fileName);
		return result;
	}
	
	@RequestMapping("/downloadCourseFile")
	@ResponseBody
	public void downloadCourseFile(String tid,String cid,HttpServletResponse response){
		String url = tcfMapper.findCFileUrl(tid, cid);
		FileUtils.downloadFile(url,response);
	}
	
}
