package com.service.serviceInterface.student.course;

import java.util.List;
import java.util.Map;

import com.entity.course.CourseInfo;
import com.entity.pojo.student.coursepojo.CourseNames;
import com.entity.pojo.student.coursepojo.MCourseRecord;
import com.entity.pojo.student.coursepojo.TCSRelsp;
import com.entity.pojo.student.coursepojo.TeacherNames;
import com.entity.userInfo.TeacherInfo;

public interface SearchCourseServiceInf {
	//通过学生学号，数据条数，数据起始位置找到对应的课程记录
	public List<MCourseRecord> searchCourseRecord(String id,int pageSize,int offset);
	//获取该学生所有课程记录的总和tcl_resp表
	public int searchTotalNumber(String sid);
	//获取学生应修的课程名字集合
	public List<CourseNames> searchCourseNames(String id);
	//获取教授该课程的老师名字集合
	public List<TeacherNames> searchTeacherNames(String cid);
	public String insertCourse(TCSRelsp tcsRelsp);
}
