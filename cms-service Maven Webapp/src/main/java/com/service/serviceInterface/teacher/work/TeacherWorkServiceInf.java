package com.service.serviceInterface.teacher.work;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.entity.pojo.teacher.workpojo.TSWorkRecord;
import com.entity.pojo.teacher.workpojo.TWork;

public interface TeacherWorkServiceInf {

	List<TWork> searchTeacherWorks(String tid, String cid, int pageSize, int offset);

	int searchTotalNumber(String tid, String cid);

	String insertWorkInfo(String tid, String cid, String subTitle, String subContent);

	List<TSWorkRecord> searchStuWorkRecord(String tid, String cid, int pageSize, int offset);

	int searchStuWorkRecordTotalNum(String tid, String cid);

	String searchWorkContent(String tid, String cid, String workName);

	void downloadWork(String sid, String cid, String tid, String workName,HttpServletResponse response);

	String finishWorkScan(String sid, String cid, String tid, String workName);

}
