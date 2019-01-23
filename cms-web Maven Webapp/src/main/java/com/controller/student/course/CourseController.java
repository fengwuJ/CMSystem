package com.controller.student.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.pojo.student.coursepojo.CourseNames;
import com.entity.pojo.student.coursepojo.MCourseRecord;
import com.entity.pojo.student.coursepojo.TCSRelsp;
import com.entity.pojo.student.coursepojo.TeacherNames;
import com.mapper.teacher.course.TeachCourseFileMapper;
import com.service.serviceInterface.student.course.SearchCourseServiceInf;
import com.utils.FileUtils;


@Controller
@RequestMapping("/static/studentview/mCourse")
public class CourseController {
	@Resource(name="scsImpl")
	private SearchCourseServiceInf scsInf;
	
	@Resource
	private TeachCourseFileMapper tcfMapper;
	
	
	@RequestMapping("/searchCourse")
	@ResponseBody
	public Map<String, Object> searchCourse(String id,int pageSize,int offset){

		List<MCourseRecord> list = scsInf.searchCourseRecord(id,pageSize,offset);
		Map<String, Object> map = new HashMap<String, Object>();
		int total = scsInf.searchTotalNumber(id);
		map.put("total",total);
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping("/searchUnselectCourse")
	@ResponseBody
	public Map<String, Object> searchUnselectCourse(String sid){
		List<CourseNames> courseNameList = scsInf.searchCourseNames(sid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseNameList", courseNameList);
		return map;
	}
	
	@RequestMapping("/searchTeacher")
	@ResponseBody
	public Map<String, Object> searchTeacher(String cid){
		List<TeacherNames> teacherNameList = scsInf.searchTeacherNames(cid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teacherNameList", teacherNameList);
		return map;
	}
	
	@RequestMapping("/insertCourse")
	@ResponseBody
	public String insertCourse(String tid,String cid,String sid){
		TCSRelsp tcsRelsp = new TCSRelsp();
		tcsRelsp.setCid(cid);
		tcsRelsp.setSid(sid);
		tcsRelsp.setTid(tid);
		tcsRelsp.setSeqNumber(-1);
		String result = scsInf.insertCourse(tcsRelsp);
		return result;
	}
	
	@RequestMapping("/downloadCourseFile")
	@ResponseBody
	public void downloadCourseFile(String tid,String cid,HttpServletResponse response) {
		String url = tcfMapper.findCFileUrl(tid, cid);
		FileUtils.downloadFile(url,response);
	}
	
}
