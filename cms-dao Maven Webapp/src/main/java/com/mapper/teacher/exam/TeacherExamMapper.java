package com.mapper.teacher.exam;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.course.CourseInfo;
import com.entity.exam.ExamInfo;
import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.ExamSingleChoice;
import com.entity.exam.ShortAnswer;
import com.entity.exam.SingleChoice;
import com.entity.exam.StuExamShortAnswer;
import com.entity.userInfo.TeacherInfo;

public interface TeacherExamMapper {

	//通过教师编号，学号，试卷名称查询试卷，返回试卷数量
	int findExamTitleCount(@Param("examTitle")String examTitle);

	//新增单选题到题库
	int insertSingleChoiceToStore(@Param("title")String singleTitle, @Param("aOption")String aOption, @Param("bOption")String bOption, @Param("cOption")String cOption, @Param("dOption")String dOption,
			@Param("rightChoice")char rightChoice);

	//检测该选择题是否存在，返回计数
	int checkSingleChoiceExsist(@Param("title")String singleTitle);
	
	//检测该简答题是否存在，返回计数
	int checkShortAnswerExsist(@Param("title")String shortTitle);

	//新增简答题到题库
	int insertShortAnsweroStore(@Param("title")String shortTitle, @Param("answer")String shortAnswer);

	//获取题库所有单选题
	List<SingleChoice> getAllSingles();

	//获取题库所有简答题
	List<ShortAnswer> getAllSAnswer();

	//插入exam_info
	int insertExamInfo(@Param("tid")String tid, @Param("cid")String cid, @Param("examName")String examName, @Param("status")String status, @Param("time")Date date);

	//根据title查询单选题
	List<SingleChoice> findExamSCByTitle(@Param("scArray")String[] scArray);

	//根据title查询多选题
	List<ShortAnswer> findExamSWByTitle(@Param("swArray")String[] swArray);

	//插入试卷单选题
	int insertExamSC(@Param("escList")List<ExamSingleChoice> escList);

	//插入试卷简答题
	int insertExamSW(@Param("esaList")List<ExamShortAnswer> esaList);

	//获取教师该课程下的学生
	List<String> findSids(@Param("tid")String tid, @Param("cid")String cid);

	//插入数据到Exam_Record
	int insertExamRecord(@Param("list")List<ExamRecord> list);

	List<ExamRecord> findExamRecord(@Param("tid")String tid, @Param("cid")String cid, @Param("offset")int offset, @Param("pageSize")int pageSize);

	int findStuExamRecordCount(@Param("tid")String tid, @Param("cid")String cid);

	//获取学生试卷单选题得分
	int findSingleChoiceGoalBy(@Param("sid")String sid, @Param("examName")String examName);

	//获取学生试卷简答题信息
	StuExamShortAnswer findShortAnswer(@Param("sid")String sid, @Param("examName")String examName);

	//查询简答题标准答案
	List<String> findStandardSA(@Param("examName")String examName);

	//更新学生考试简答题得分
	int updateSAGoal(@Param("examName")String examName, @Param("sid")String sid, @Param("shortGoal")int shortGoal);

	//更新学生考试总分
	int updateTotalGoal(@Param("examName")String examName, @Param("sid")String sid, @Param("cid")String cid, @Param("tid")String tid, @Param("totalGoal")int totalGoal);

	//查询未批改试卷数量
	int findNotScanCount(@Param("examName")String examName);

	//更新试卷批改状态
	void updateExamStatus(@Param("examName")String examName, @Param("status")String status);

	List<ExamInfo> getExamList(@Param("tid")String tid,@Param("offset")int offset,@Param("pageSize")int pageSize,@Param("cid")String cid);

	int getExamTotalNumberById(@Param("tid")String tid,@Param("cid")String cid);

	TeacherInfo getTeacherInfoById(@Param("tid")String tid);

	CourseInfo getCourseInfoById(@Param("cid")String cid);

	List<ExamSingleChoice> getExamSingleChoiceByName(@Param("examName")String examName);

	List<ExamShortAnswer> getExamShortAnswerByName(@Param("examName")String examName);

	
}
