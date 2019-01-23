package com.controller.student.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.exam.ExamInfo;
import com.entity.exam.ExamRecord;
import com.entity.exam.ExamShortAnswer;
import com.entity.exam.ExamSingleChoice;
import com.entity.exam.StuExamShortAnswer;
import com.entity.pojo.student.examrecordpojo.ExamRecordPojo;
import com.mapper.student.exam.StuExamMapper;
import com.service.serviceInterface.student.exam.SearchExamServiceInf;

@Controller
@RequestMapping("/static/studentview/mExam")
public class SearchExamController {
	@Resource(name="sesImpl")
	private SearchExamServiceInf sesInf;
	
	@Resource(name="stuExamMapper")
	private StuExamMapper stuExamMapper;
	
	@RequestMapping("/searchExamRecord")
	@ResponseBody
	public Map<String, Object> searchExamRecord(String uid,int pageSize,int offset){
		List<ExamRecordPojo> list = sesInf.searchExamRecord(uid,pageSize,offset);
		Map<String, Object> map = new HashMap<String, Object>();
		int total = sesInf.searchTotalNumber(uid);
		map.put("total",total);
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping("/getSingleChoice")
	@ResponseBody
	public Map<String, Object> getSingleChoice(int currentPage,String examName){
		ExamSingleChoice esc = stuExamMapper.getSingleChoice(currentPage-1,examName);
		esc.setRightChoice('e');
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("esc", esc);
		return map;
	}
	
	@RequestMapping("/getSCTotalPage")
	@ResponseBody
	public int getSCTotalPage(String examName){
		int totalPage = stuExamMapper.getSCTotalPage(examName);
		return totalPage;
	}
	
	@RequestMapping("/isExam")
	@ResponseBody
	public String isExam(String sid){
		String result = sesInf.isExam(sid);
		return result;
	}
	
	
	@RequestMapping("/getShortAnswer")
	@ResponseBody
	public Map<String, Object> getShortAnswer(String examName){
		List<ExamShortAnswer> saList = sesInf.getShortAnswer(examName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saList", saList);
		return map;
	}
	
	@RequestMapping("/submitAnswer")
	@ResponseBody
	public String submitAnswer(String sid,String examName,Character[] singleChoice,String[] shortAnswer){
		//计算单选题得分，插入exam_record
		List<Character> singleChoiceList = stuExamMapper.findExamSingleChoice(examName);
		int choiceGoal = 0;
		for (int i = 0; i < singleChoiceList.size(); i++) {
			if (singleChoiceList.get(i).equals(singleChoice[i])) {
				choiceGoal += 10;
			}
		}
		
		//插入StuExamShortAnswer，等待老师给分
		StuExamShortAnswer sesaAnswer = new StuExamShortAnswer();
		sesaAnswer.setExamName(examName);
		sesaAnswer.setSid(sid);
		sesaAnswer.setA1(shortAnswer[0]);
		sesaAnswer.setA2(shortAnswer[1]);
		sesaAnswer.setA3(shortAnswer[2]);
		//事务方式提交
		sesInf.submitAnswer(choiceGoal,examName,sid,sesaAnswer);
		return "提交成功";
	}
	
}
