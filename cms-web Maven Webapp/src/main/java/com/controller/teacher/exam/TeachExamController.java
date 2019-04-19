package com.controller.teacher.exam;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.course.CourseInfo;
import com.entity.exam.ExamInfo;
import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.ExamSingleChoice;
import com.entity.exam.ShortAnswer;
import com.entity.exam.SingleChoice;
import com.entity.pojo.teacher.examPojo.TExamRecordPojo;
import com.entity.userInfo.TeacherInfo;
import com.itextpdf.text.DocumentException;
import com.mapper.teacher.exam.TeacherExamMapper;
import com.service.serviceInterface.teacher.exam.TeacherExamServiceInf;
import com.utils.FileUtils;

import io.lettuce.core.output.SocketAddressOutput;

@Controller
@RequestMapping("/static/teacherview/mExam")
public class TeachExamController {
	@Resource(name="tesImpl")
	private TeacherExamServiceInf tesInf;
	
	@Resource
	private TeacherExamMapper teacherExamMapper;
	
	//检查试卷是否重名
	@RequestMapping("/checkExamTitleExist")
	@ResponseBody
	
	public boolean checkExamTitleExist(String examTitle) {
		boolean flag = tesInf.isExamTitleExist(examTitle);
		return flag;
	}
	
	//新增题库单选题
	@RequestMapping("/insertSingleChoice")
	@ResponseBody
	@CacheEvict(value="allSingles", key="'allSingles'")
	public String insertSingleChoice(String singleTitle,String aOption,String bOption,String cOption,String dOption,char rightChoice) {
		String result = tesInf.insertSingleChoiceToStore(singleTitle,aOption,bOption,cOption,dOption,rightChoice);
		return result;
	}
	
	//新增题库简答题
	@RequestMapping("/insertShortAnswer")
	@ResponseBody
	@CacheEvict(value="allWrites", key="'allWrites'")
	public String insertShortAnswer(String shortTitle,String shortAnswer) {
		String result = tesInf.insertShortAnswer(shortTitle,shortAnswer);
		return result;
	}
	
	@RequestMapping("/getSingles")
	@ResponseBody
	@Cacheable(value="allSingles", key="'allSingles'")
	public Map<String, Object> getSingles() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SingleChoice> list = tesInf.getAllSingles();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping("/getWrites")
	@ResponseBody
	@Cacheable(value="allWrites", key="'allWrites'")
	public Map<String, Object> getWrites(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShortAnswer> list = tesInf.getAllSAnswer();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping("/insertExam")
	@ResponseBody
	public String insertExam(String tid,String cid,String examName,String[] scArray,String[] swArray) {
		String result = tesInf.insertExam(tid,cid,examName,scArray,swArray);
		return result;
	}
	
	//获取教师下的学生考试记录
	@RequestMapping("/getStuExamRecord")
	@ResponseBody
	public Map<String, Object> getStuExamRecord(int pageSize,int offset,String tid, String cid) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TExamRecordPojo> list = tesInf.findStuExamRecord(pageSize,offset,tid,cid);
		int count = tesInf.findStuExamRecordCount(tid,cid);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	
	//获取单个学生考试信息
	@RequestMapping("/searchSingleExam")
	@ResponseBody
	public Map<String, Object> searchSingleExam(String sid,String examName) {
		return tesInf.searchSingleExam(sid,examName);
	}
	
	//批改简答题和更新学生考试总成绩
	@RequestMapping("/updateSAandTotalGoal")
	@ResponseBody
	public String updateSAandTotalGoal(String sid,String tid,String cid,String examName, int shortGoal, int totalGoal) {
		String result = tesInf.updateSAandTotalGoal(sid,tid,cid,examName,shortGoal,totalGoal);
		int notScanCount = teacherExamMapper.findNotScanCount(examName);
		if(notScanCount == 0){
			teacherExamMapper.updateExamStatus(examName,"已批改");
		}
		return result;
	}
	
	//获取教师试卷列表
	@RequestMapping("/getExamList")
	@ResponseBody
	public Map<String, Object> getExamList(String tid,int pageSize,int offset,String cid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ExamInfo> list = tesInf.getExamList(tid,offset,pageSize,cid);
		int count = tesInf.getExamTotalNumberById(tid,cid);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	
	@RequestMapping("/getPdf")
	@ResponseBody
	public void getPdf(String tid,String examName,String cid,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		TeacherInfo teacherInfo = teacherExamMapper.getTeacherInfoById(tid);
		CourseInfo courseInfo = teacherExamMapper.getCourseInfoById(cid);
		List<ExamSingleChoice> examSingleChoiceList = teacherExamMapper.getExamSingleChoiceByName(examName);
		List<ExamShortAnswer> examShortAnswerList = teacherExamMapper.getExamShortAnswerByName(examName);
		map.put("teacherInfo",teacherInfo);
		map.put("courseInfo",courseInfo);
		map.put("examSingleChoiceList",examSingleChoiceList);
		map.put("examShortAnswerList",examShortAnswerList);
		try {
			FileUtils.getPdF(examName,map,response);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
