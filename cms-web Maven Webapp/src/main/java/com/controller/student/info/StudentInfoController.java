package com.controller.student.info;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.userInfo.StudentInfo;
import com.service.serviceInterface.student.info.SearchStudentInfoServiceInf;

@Controller
@RequestMapping("/static/studentview/mInfo")
public class StudentInfoController {
	@Resource(name="searchStuInfoServImpl")
	private SearchStudentInfoServiceInf ssisInf;
	
	@RequestMapping("/searchStudentInfo")
	@ResponseBody
	public Map<String, Object> searchStudentInfo(String sid){
		StudentInfo studentInfo = ssisInf.searchStudentInfoById(sid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentInfo", studentInfo);
		return map;
	}
	
	@RequestMapping("/updatePhoneNumber")
	@ResponseBody
	public String updatePhoneNumber(String sid,String phoneNumber){
		String result = ssisInf.updatePhoneNumberById(sid,phoneNumber);
		return result;
	}
	
	@RequestMapping("/checkPwssword")
	@ResponseBody
	public String checkPwssword(String sid,String oldPwd){
		String result = ssisInf.checkPwsswordById(sid,oldPwd);
		return result;
	}
	
	@RequestMapping("/updatePwssword")
	@ResponseBody
	public String updatePwssword(String sid,String newPwd){
		String result = ssisInf.updatePwsswordById(sid,newPwd);
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("userId");
			session.removeAttribute("userName");
			session.invalidate();
		}
		
		return "myRedirect";
	}
	
}
