package com.service.serviceInterface.student.exam;

import java.util.List;

import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.StuExamShortAnswer;
import com.entity.pojo.student.examrecordpojo.ExamRecordPojo;

public interface SearchExamServiceInf {

	List<ExamRecordPojo> searchExamRecord(String uid, int pageSize, int offset);

	int searchTotalNumber(String uid);

	String isExam(String sid);

	List<ExamShortAnswer> getShortAnswer(String examName);

	void submitAnswer(int choiceGoal, String examName, String sid, StuExamShortAnswer sesaAnswer);

	
}
