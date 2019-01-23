package com.mapper.student.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.course.CourseInfo;
import com.entity.pojo.student.coursepojo.CourseNames;
import com.entity.pojo.student.coursepojo.TCSRelsp;
import com.entity.userInfo.TeacherInfo;

public interface StuCourseMapper {
	//通过学生学号获取课程信息 stu_course_relsp
	public List<CourseInfo> searchCourseInfo(@Param("id")String id);
	//通过学生学号和课程信息获取教师信息 tcs_relsp
	public TeacherInfo searchTeacherInfo(@Param("sid")String sid,@Param("cid")String cid);
	//通过学生学号和课程号获取该学生在修课程记录数 tcs_relsp
	public int searchTotalNumber(@Param("sid")String sid,@Param("cid")String cid);
	
	//通过学生学号获取课程信息 stu_course_relsp
	//因为是插入数据，所以要求stu_course_relsp中有数据但tcs_relsp中没有
	public List<CourseInfo> searchUnselectCourseInfo(@Param("id")String id);
	
	//通过cid在course_teacher_relsp中寻找对应的tid和tInfo
	public List<TeacherInfo> searchTeacherNames(@Param("cid")String cid);
	public void insertCourse(@Param("tcsRelsp")TCSRelsp tcsRelsp);
	
	//获取课程课件状态
	public String searchCourseFileStatus(@Param("cid")String cid, @Param("tid")String tid);
	
	//通过id获取课程名
	public String findNameById(@Param("cid")String cid);
}
