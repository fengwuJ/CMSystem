package com.service.serviceImpl.student.exam;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.StuExamShortAnswer;
import com.entity.pojo.student.examrecordpojo.ExamRecordPojo;
import com.entity.tcsrelsp.TCSPojo;
import com.mapper.student.exam.StuExamMapper;
import com.service.serviceInterface.student.exam.SearchExamServiceInf;

@Service("sesImpl")
public class SearchExamServiceImpl implements SearchExamServiceInf {
	@Resource(name="stuExamMapper")
	private StuExamMapper stuExamMapper;

	@Override
	public int searchTotalNumber(String uid) {
		// TODO Auto-generated method stub
		int number = stuExamMapper.searchTotalNumber(uid);
		return number;
	}

	
	@Override
	public List<ExamRecordPojo> searchExamRecord(String uid, int pageSize, int offset) {
		// TODO Auto-generated method stub
		List<ExamRecord> examRecordList = stuExamMapper.searchExamRecord(uid,pageSize,offset);
		List<ExamRecordPojo> examRecordPojoList = new ArrayList<ExamRecordPojo>();
		for (ExamRecord er : examRecordList) {
			ExamRecordPojo examRecordPojo = new ExamRecordPojo();
			examRecordPojo.setCid(er.getCid());
			examRecordPojo.setCname(er.getCname());
			examRecordPojo.setExamName(er.getExamName());
			examRecordPojo.setGoal(er.getGoal());
			examRecordPojo.setTime(er.getTime());
			examRecordPojoList.add(examRecordPojo);
		}
		return examRecordPojoList;
	}


	@Override
	public String isExam(String sid) {
		// TODO Auto-generated method stub
		String result = null;
		String examName = null;
		//通过学号查询自己的课程编号和教师编号tcs_relsp
		List<TCSPojo> tcsPojoList = stuExamMapper.findTCIdBySid(sid);
		int answerRecord = 0;
		//通过课程编号和教师编号定位发布的exam  status
		//检查是否有满足条件的试卷
		for (TCSPojo tcsPojo : tcsPojoList) {
			int number = stuExamMapper.findExamCount(tcsPojo.getCid(),tcsPojo.getTid(),"未批改");
			if (number > 0) {
				examName = stuExamMapper.findExamName(tcsPojo.getCid(),tcsPojo.getTid(),"未批改");
				answerRecord = stuExamMapper.findAnswerRecord(sid,examName);
				if (answerRecord > 0) {
					result = "no";
				}else {
					result = examName;
				}
			}else {
				result = "no";
			}
		}
		
		//通过exam status的状态判断是否返回no 即，是否开启答卷
		return result;
	}


	@Override
	public List<ExamShortAnswer> getShortAnswer(String examName) {
		// TODO Auto-generated method stub
		List<ExamShortAnswer> list = stuExamMapper.findExamShortAnswerByExamname(examName);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAnswer("");
		}
		return list;
	}


	@Override
	@Transactional
	public void submitAnswer(int choiceGoal, String examName, String sid, StuExamShortAnswer sesaAnswer){
		// TODO Auto-generated method stub
		Date date = new Date(System.currentTimeMillis());
		stuExamMapper.updateExamTime(examName,sid,date);
		stuExamMapper.insertSingleChoiceGoal(choiceGoal,examName,sid);
		stuExamMapper.insertShortAnswer(sesaAnswer);
	
		
	}

}
