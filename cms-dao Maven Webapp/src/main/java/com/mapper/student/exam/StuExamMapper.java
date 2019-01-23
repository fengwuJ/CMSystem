package com.mapper.student.exam;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.ExamSingleChoice;
import com.entity.exam.StuExamShortAnswer;
import com.entity.tcsrelsp.TCSPojo;

public interface StuExamMapper {

	int searchTotalNumber(@Param("uid")String uid);

	List<ExamRecord> searchExamRecord(@Param("uid")String uid,@Param("pageSize") int pageSize,@Param("offset") int offset);

	ExamSingleChoice getSingleChoice(@Param("currentPage")int currentPage, @Param("examName")String examName);

	int getSCTotalPage(@Param("examName")String examName);

	List<TCSPojo> findTCIdBySid(@Param("sid")String sid);

	int findExamCount(@Param("cid")String cid, @Param("tid")String tid,@Param("status")String status);

	String findExamName(@Param("cid")String cid, @Param("tid")String tid, @Param("status")String status);

	List<ExamShortAnswer> findExamShortAnswerByExamname(@Param("examName")String examName);

	int findAnswerRecord(@Param("sid")String sid, @Param("examName")String examName);

	List<Character> findExamSingleChoice(@Param("examName")String examName);

	void insertSingleChoiceGoal(@Param("choiceGoal")int choiceGoal, @Param("examName")String examName, @Param("sid")String sid);

	void insertShortAnswer(@Param("sesaAnswer")StuExamShortAnswer sesaAnswer);

	void updateExamTime(@Param("examName")String examName, @Param("sid")String sid, @Param("date")Date date);
	
}
