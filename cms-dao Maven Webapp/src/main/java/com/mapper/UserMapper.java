package com.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.course.CourseInfo;
import com.entity.pojo.student.coursepojo.TCourse;

public interface UserMapper {
	//学生的数据
	public boolean checkExistByStuId(@Param("id")String id);
	public String findPasswordByStuId(@Param("id")String id);
	public String findStudentNameById(@Param("id")String id);
	
	//老师的数据
	public boolean checkExistByTeachId(@Param("id")String id);
	public String findPasswordByTeachId(@Param("id")String id);
	public String findTeacherNameById(@Param("id")String id);
	public List<CourseInfo> getMyCourse(@Param("tid")String tid);
}
