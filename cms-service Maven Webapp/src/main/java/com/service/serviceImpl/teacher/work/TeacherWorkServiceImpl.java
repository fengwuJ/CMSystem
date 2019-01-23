package com.service.serviceImpl.teacher.work;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.pojo.teacher.workpojo.TSWorkRecord;
import com.entity.pojo.teacher.workpojo.TWork;
import com.entity.work.WorkFile;
import com.entity.work.WorkInfo;
import com.mapper.UserMapper;
import com.mapper.student.work.StuWorkMapper;
import com.mapper.teacher.work.TeacherWorkMapper;
import com.service.serviceInterface.teacher.work.TeacherWorkServiceInf;
import com.utils.FileUtils;

@Service("twsImpl")
public class TeacherWorkServiceImpl implements TeacherWorkServiceInf{

	@Resource
	private TeacherWorkMapper twMapper;
	@Resource
	private StuWorkMapper stuWorkMapper;
	@Resource
	private UserMapper UserMapper;
	
	//发布作业记录
	@Override
	public List<TWork> searchTeacherWorks(String tid, String cid, int pageSize, int offset) {
		List<WorkInfo> workInfoList = twMapper.searchWorkInfo(tid,cid);
		List<TWork> tworkList = new ArrayList<TWork>();
		for (int i = 0; i < workInfoList.size(); i++) {
			if (tworkList.size() == pageSize) {
				break;
			}
			
			if (i >= offset) {
				TWork tWork = new TWork();
				WorkInfo workInfo = workInfoList.get(i);
				tWork.setCid(workInfo.getCid());
				tWork.setCname(twMapper.findCnameByCid(workInfo.getCid()));
				tWork.setWorkName(workInfo.getWorkName());
				tWork.setContent(workInfo.getContent());
				tworkList.add(tWork);
			}
		}

		return tworkList;
	}

	//发布作业总记录数
	@Override
	public int searchTotalNumber(String tid, String cid) {
		// TODO Auto-generated method stub
		int number = twMapper.searchTotalNumber(tid,cid);
		return number;
	}

	//新增作业
	@Override
	@Transactional
	public String insertWorkInfo(String tid, String cid, String subTitle, String subContent) {
		// TODO Auto-generated method stub
		int count = twMapper.checkMul(tid,cid,subTitle);
		if(count > 0){
			return "作业重名，请修改作业标题";
		}else {
			List<String> stuList = twMapper.findStuIds(tid,cid);
			twMapper.insertWorkInfo(tid, cid, subTitle, subContent);
			for (int i = 0; i < stuList.size(); i++) {
				WorkFile workFile = new WorkFile();
				workFile.setCid(cid);
				workFile.setTid(tid);
				workFile.setSid(stuList.get(i));
				workFile.setStatus("未提交");
				workFile.setWorkName(subTitle);
				twMapper.insertWorkFile(workFile);
			}
			return "作业已发布";
			
		}
	}

	//批改作业，学生作业记录
	@Override
	public List<TSWorkRecord> searchStuWorkRecord(String tid, String cid, int pageSize, int offset) {
		// TODO Auto-generated method stub
		List<TSWorkRecord> tsWorkRecordList = twMapper.searchStuWorkRecord(tid,cid,pageSize,offset);
		for (int i = 0; i < tsWorkRecordList.size(); i++) {
			tsWorkRecordList.get(i).setSname(UserMapper.findStudentNameById(tsWorkRecordList.get(i).getSid()));
		}
		return tsWorkRecordList;
	}

	//该教师下学生作业记录数
	@Override
	public int searchStuWorkRecordTotalNum(String tid, String cid) {
		// TODO Auto-generated method stub
		int number = twMapper.searchStuWorkRecordTotalNum(tid,cid);
		return number;
	}

	//单条作业详情
	@Override
	public String searchWorkContent(String tid, String cid, String workName) {
		// TODO Auto-generated method stub
		String result = null;
		List<WorkInfo> list = twMapper.searchWorkInfo(tid, cid);
		for (int i = 0; i < list.size(); i++) {
			if (workName.equals(list.get(i).getWorkName())) {
				result = list.get(i).getContent();
			}
		}
		return result;
	}

	@Override
	public void downloadWork(String sid, String cid, String tid, String workName,HttpServletResponse response) {
		// TODO Auto-generated method stub
		String url = twMapper.findWorkFileUrl(sid,cid,tid,workName);
		Date date = new Date(System.currentTimeMillis());
		twMapper.updateCorrctTime(sid,cid,tid,workName,date);
		FileUtils.downloadFile(url, response);
	}

	@Override
	public String finishWorkScan(String sid, String cid, String tid, String workName) {
		// TODO Auto-generated method stub
		Date date = new Date(System.currentTimeMillis());
		twMapper.updateCorrctTime(sid,cid,tid,workName,date);
		return "批改成功";
	}

}
