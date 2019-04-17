package com.service.serviceImpl.teacher.exam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.course.CourseInfo;
import com.entity.exam.ExamInfo;
import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.ExamSingleChoice;
import com.entity.exam.ShortAnswer;
import com.entity.exam.SingleChoice;
import com.entity.exam.StuExamShortAnswer;
import com.entity.pojo.teacher.examPojo.TExamRecordPojo;
import com.mapper.UserMapper;
import com.mapper.student.course.StuCourseMapper;
import com.mapper.teacher.exam.TeacherExamMapper;
import com.service.serviceInterface.teacher.exam.TeacherExamServiceInf;

@Service("tesImpl")
public class TeacherExamServiceImpl implements TeacherExamServiceInf{
	@Resource
	private TeacherExamMapper teacherExamMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource(name = "stuCourseMapper")
	private StuCourseMapper stuCourseMapper;
	//检查试卷重名，返回true || false
	@Override
	public boolean isExamTitleExist(String examTitle) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int count = teacherExamMapper.findExamTitleCount(examTitle);
		if (count > 0) {
			flag = true;
		}
		return flag;
	}

	//插入单选题到题库
	@Override
	public String insertSingleChoiceToStore(String singleTitle, String aOption, String bOption, String cOption,
			String dOption, char rightChoice) {
		// TODO Auto-generated method stub
		String result = null;
		int rowAffect = 0;
		int exsist = teacherExamMapper.checkSingleChoiceExsist(singleTitle);
		if (exsist > 0) {
			result = "该选择题目已存在，无需新增";
		}else {
			rowAffect = teacherExamMapper.insertSingleChoiceToStore(singleTitle,aOption,bOption,cOption,dOption,rightChoice);
			if (rowAffect > 0) {
				result = "成功新增单选题";
			}else {
				result = "单选题新增失败";
			}
		}
		return result;
	}

	@Override
	public String insertShortAnswer(String shortTitle, String shortAnswer) {
		// TODO Auto-generated method stub
		String result = null;
		int rowAffect = 0;
		int exsist = teacherExamMapper.checkShortAnswerExsist(shortTitle);
		if (exsist > 0) {
			result = "该简答题已存在，无需新增";
		}else {
			rowAffect = teacherExamMapper.insertShortAnsweroStore(shortTitle,shortAnswer);
			if (rowAffect > 0) {
				result = "简答题新增成功";
			}else {
				result = "简答题新增失败";
			}
		}
		return result;

	}

	//获取题库所有选择题
	@Override
	public List<SingleChoice> getAllSingles() {
		// TODO Auto-generated method stub
		List<SingleChoice> list = teacherExamMapper.getAllSingles();
		return list;
	}

	//获取题库所有单选题
	@Override
	public List<ShortAnswer> getAllSAnswer() {
		// TODO Auto-generated method stub
		List<ShortAnswer> list = teacherExamMapper.getAllSAnswer();
		return list;
	}

	/**
	 * @param tid  教师编号
	 * @param cid	课程号
	 * @param examName	试卷名称
	 * @param scArray	单选题题目数组
	 * @param swArray	简答题题目数组
	 * @return String 执行状态
	 */
	@Transactional
	@Override
	public String insertExam(String tid, String cid, String examName, String[] scArray, String[] swArray) {
		// TODO Auto-generated method stub
		String result = null;
		List<ExamSingleChoice> escList = new ArrayList<ExamSingleChoice>();
		List<ExamShortAnswer> esaList = new ArrayList<ExamShortAnswer>();
		Date date = new Date(System.currentTimeMillis());
		//插入exam_info
		int rowExamInfoAffect = teacherExamMapper.insertExamInfo(tid,cid,examName,"未批改",date);
		//插入exam_record
		List<ExamRecord> list = new ArrayList<ExamRecord>();
		List<String> sidList = teacherExamMapper.findSids(tid,cid);
		for (int i = 0; i < sidList.size(); i++) {
			ExamRecord er = new ExamRecord();
			er.setExamName(examName);
			er.setSid(sidList.get(i));
			er.setCid(cid);
			er.setTid(tid);
			er.setCname(stuCourseMapper.findNameById(cid));
			er.setTname(userMapper.findTeacherNameById(tid));
			list.add(er);
		}
		
		int rowERAffect = teacherExamMapper.insertExamRecord(list);
		if (rowExamInfoAffect > 0 && rowERAffect == sidList.size()) {
			List<SingleChoice> scList = teacherExamMapper.findExamSCByTitle(scArray);
			for (int i = 0; i < scList.size(); i++) {
				ExamSingleChoice esc = new ExamSingleChoice();
				SingleChoice sc = scList.get(i);
				esc.setExamName(examName);
				esc.setTitle(sc.getTitle());
				esc.setaOption(sc.getaOption());
				esc.setbOption(sc.getbOption());
				esc.setcOption(sc.getcOption());
				esc.setdOption(sc.getdOption());
				esc.setRightChoice(sc.getRightChoice());
				escList.add(esc);
			}
			List<ShortAnswer> swList = teacherExamMapper.findExamSWByTitle(swArray);
			for (int i = 0; i < swList.size(); i++) {
				ShortAnswer sa = swList.get(i);
				ExamShortAnswer esa = new ExamShortAnswer();
				esa.setExamName(examName);
				esa.setTitle(sa.getTitle());
				esa.setAnswer(sa.getAnswer());
				esaList.add(esa);
			}
			
			int rowsingleChoiceAffect = teacherExamMapper.insertExamSC(escList);
			int rowShortAnswerAffect = teacherExamMapper.insertExamSW(esaList);
			if(rowsingleChoiceAffect == escList.size() && rowShortAnswerAffect == esaList.size()){
				
				result = "试卷发布成功";
			}
		}else {
			result = "试卷发布失败";
		}
		
		return result;
	}

	@Override
	public List<TExamRecordPojo> findStuExamRecord(int pageSize, int offset, String tid, String cid) {
		// TODO Auto-generated method stub
		List<ExamRecord> list = teacherExamMapper.findExamRecord(tid,cid,offset,pageSize);
		List<TExamRecordPojo> erpList = new ArrayList<TExamRecordPojo>();
		for (int i = 0; i < list.size(); i++) {
			TExamRecordPojo erp = new TExamRecordPojo();
			ExamRecord er = list.get(i);
			erp.setCid(er.getCid());
			erp.setCname(er.getCname());
			erp.setExamName(er.getExamName());
			erp.setSid(er.getSid());
			erp.setSname(userMapper.findStudentNameById(er.getSid()));
			erp.setTid(er.getTid());
			erp.setTname(er.getTname());
			erp.setTime(er.getTime());
			erp.setGoal(er.getGoal());
			erpList.add(erp);
		}
		return erpList;
	}

	@Override
	public int findStuExamRecordCount(String tid, String cid) {
		// TODO Auto-generated method stub
		int number = teacherExamMapper.findStuExamRecordCount(tid,cid);
		return number;
	}

	@Override
	public Map<String, Object> searchSingleExam(String sid, String examName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		int singleGoal = teacherExamMapper.findSingleChoiceGoalBy(sid,examName);
		int totalGoal = singleGoal;
		StuExamShortAnswer sesAnswer = teacherExamMapper.findShortAnswer(sid,examName);
		List<String> standardAnswerList = teacherExamMapper.findStandardSA(examName);
		map.put("totalGoal", totalGoal);
		map.put("singleGoal", singleGoal);
		map.put("saInfo", sesAnswer);
		map.put("standardAnswers", standardAnswerList);
		return map;
	}

	@Transactional
	@Override
	public String updateSAandTotalGoal(String sid, String tid, String cid, String examName, int shortGoal,
			int totalGoal) {
		// TODO Auto-generated method stub
		String result = null;
		int saGoalAffect = teacherExamMapper.updateSAGoal(examName,sid,shortGoal);
		int totalGoalAffect = teacherExamMapper.updateTotalGoal(examName,sid,cid,tid,totalGoal);
		if (saGoalAffect > 0 && totalGoalAffect > 0) {
			result = "试卷批改成功";
		}else {
			result = "服务器出现未知错误，请稍后重试";
		}
		return result;
	}

	@Override
	public List<ExamInfo> getExamList(String tid,int offset,int pageSize,String cid) {
		List<ExamInfo> list = teacherExamMapper.getExamList(tid,offset,pageSize,cid);
		return list;
	}

	@Override
	public int getExamTotalNumberById(String tid,String cid) {
		return teacherExamMapper.getExamTotalNumberById(tid,cid);
	}
}
