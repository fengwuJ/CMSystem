package com.mapper.student.work;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.course.CourseInfo;
import com.entity.tcsrelsp.TCSPojo;
import com.entity.userInfo.TeacherInfo;
import com.entity.work.WorkFile;
import com.entity.work.WorkInfo;

public interface StuWorkMapper {

	List<WorkInfo> searchWorkInfo(@Param("tid")String tid,@Param("cid")String cid);

	WorkFile searchWorkFile(@Param("sid")String sid, @Param("cid")String cid, @Param("tid")String tid,@Param("workName")String workName);

	int searchTotalNumber(@Param("tid")String tid,@Param("cid")String cid);

	String findCnameByCid(@Param("cid")String cid);

	String findTnameByTid(@Param("tid")String tid);

	List<TCSPojo> searchTemp(@Param("sid")String sid);

	int updateWorkFile(@Param("url")String path, @Param("tid")String tid, @Param("cid")String cid, @Param("sid")String sid, @Param("workName")String workTitle, @Param("status")String status,@Param("submitTime")Date date);
	
}
