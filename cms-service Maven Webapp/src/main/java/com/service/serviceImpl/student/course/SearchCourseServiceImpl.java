package com.service.serviceImpl.student.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.course.CourseInfo;
import com.entity.pojo.student.coursepojo.CourseNames;
import com.entity.pojo.student.coursepojo.MCourseRecord;
import com.entity.pojo.student.coursepojo.TCSRelsp;
import com.entity.pojo.student.coursepojo.TeacherNames;
import com.entity.userInfo.TeacherInfo;
import com.mapper.student.course.StuCourseMapper;
import com.service.serviceInterface.student.course.SearchCourseServiceInf;

@Service("scsImpl")
public class SearchCourseServiceImpl implements SearchCourseServiceInf{

	@Resource(name = "stuCourseMapper")
	private StuCourseMapper stuCourseMapper;
	
	@Override
	public List<MCourseRecord> searchCourseRecord(String id,int pageSize,int offset) {
		List<CourseInfo> courseInfoList = stuCourseMapper.searchCourseInfo(id);
		List<MCourseRecord> mCourseRecordsList = new ArrayList<MCourseRecord>();
		for (int i = 0; i < courseInfoList.size(); i++) {
			CourseInfo courseInfo = courseInfoList.get(i);
			TeacherInfo teacherInfo = stuCourseMapper.searchTeacherInfo(id, courseInfo.getId());
			if (teacherInfo == null) {
				continue;
			}
			
			String status = stuCourseMapper.searchCourseFileStatus(courseInfo.getId(),teacherInfo.getId());
			
			if (mCourseRecordsList.size() == pageSize) {
				break;
			}
			
			if (i >= offset) {
				MCourseRecord mcr = new MCourseRecord();
				mcr.setCid(courseInfo.getId());
				mcr.setCname(courseInfo.getName());
				mcr.setTname(teacherInfo.getName());
				mcr.setTid(teacherInfo.getId());
				mcr.setStatus(status);
				mCourseRecordsList.add(mcr);
			}
		}

		return mCourseRecordsList;
	}

	@Override
	public int searchTotalNumber(String sid) {
		// TODO Auto-generated method stub
		int totalNumber = 0;
		int flag = 0;
		List<CourseInfo> courseInfoList = stuCourseMapper.searchCourseInfo(sid);
		for(int i = 0; i < courseInfoList.size(); i++){
			//一条条找，找到为1，找不到为0
			flag = stuCourseMapper.searchTotalNumber(sid, courseInfoList.get(i).getId());
			if (flag == 0) {
				continue;
			}
			totalNumber += 1;
		}
		return totalNumber;
	}

	@Override
	public List<CourseNames> searchCourseNames(String id) {
		// TODO Auto-generated method stub
		List<CourseInfo> courseInfoList = stuCourseMapper.searchUnselectCourseInfo(id);
		List<CourseNames> courseNameList = new ArrayList<CourseNames>();
		for (int i = 0; i < courseInfoList.size(); i++) {
			CourseNames cn = new CourseNames();
			cn.setCourseName(courseInfoList.get(i).getName());
			cn.setCourseId(courseInfoList.get(i).getId());
			courseNameList.add(cn);
		}
		return courseNameList;
	}

	@Override
	public List<TeacherNames> searchTeacherNames(String cid) {
		List<TeacherInfo> teacherInfoList = stuCourseMapper.searchTeacherNames(cid);
		List<TeacherNames> teacherNameList = new ArrayList<TeacherNames>();
		for (int i = 0; i < teacherInfoList.size(); i++) {
			TeacherNames tn = new TeacherNames();
			tn.setTeacherId(teacherInfoList.get(i).getId());
			tn.setTeacherName(teacherInfoList.get(i).getName());
			teacherNameList.add(tn);
		}
		return teacherNameList;
	}

	@Override
	public String insertCourse(TCSRelsp tcsRelsp) {
		// TODO Auto-generated method stub
		//插入数据
		stuCourseMapper.insertCourse(tcsRelsp);
		tcsRelsp.getSeqNumber();
		return "课程添加成功";
	}

	
}
