package com.mapper.teacher.course;

import org.apache.ibatis.annotations.Param;

import com.entity.course.CourseFile;

public interface TeachCourseFileMapper {

	CourseFile findCourseFile(@Param("tid")String tid, @Param("cid")String cid);

	void updateCourseFileStatus(@Param("url")String url,@Param("tid")String tid,@Param("cid")String cid,@Param("status")String status);

	String findCFileUrl(@Param("tid")String tid, @Param("cid")String cid);

}
