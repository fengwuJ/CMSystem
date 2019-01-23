package com.service.serviceInterface.teacher.course;

import java.io.FileNotFoundException;

import org.springframework.web.multipart.MultipartFile;

import com.entity.course.CourseFile;

public interface SearchCourseFileServiceInf {

	CourseFile searchCourseFile(String tid, String cid);

	String uploadCourseFile(String tid, String cid, MultipartFile file);

	String checkCFileExsist(String tid, String cid, String fileName);
	
}
