package com.service.serviceInterface.teacher.exam;

import java.util.List;
import java.util.Map;

import com.entity.exam.ExamRecord;
import com.entity.exam.ShortAnswer;
import com.entity.exam.SingleChoice;
import com.entity.pojo.teacher.examPojo.TExamRecordPojo;

public interface TeacherExamServiceInf {

	boolean isExamTitleExist(String examTitle);

	String insertSingleChoiceToStore(String singleTitle, String aOption, String bOption, String cOption, String dOption,
			char rightChoice);

	String insertShortAnswer(String shortTitle, String shortAnswer);

	List<SingleChoice> getAllSingles();

	List<ShortAnswer> getAllSAnswer();

	String insertExam(String tid, String cid, String examName, String[] scArray, String[] swArray);

	List<TExamRecordPojo> findStuExamRecord(int pageSize, int offset, String tid, String cid);

	int findStuExamRecordCount(String tid, String cid);

	Map<String, Object> searchSingleExam(String sid, String examName);

	String updateSAandTotalGoal(String sid, String tid, String cid, String examName, int shortGoal, int totalGoal);

}
