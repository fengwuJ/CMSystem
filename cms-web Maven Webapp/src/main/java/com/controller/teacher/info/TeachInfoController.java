package com.controller.teacher.info;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.userInfo.TeacherInfo;
import com.service.serviceInterface.teacher.info.SearchTeacherInfoInf;

@Controller
@RequestMapping("/static/teacherview/mInfo")
public class TeachInfoController {
	@Resource(name="stisImpl")
	private SearchTeacherInfoInf stiInf;

	@RequestMapping("/searchMyInfo")
	@ResponseBody
	public Map<String, Object> searchMyInfo(String tid){
		TeacherInfo teacherInfo = stiInf.searchTeacherInfoById(tid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teacherInfo", teacherInfo);
		return map;
	}
	
	@RequestMapping("/updateInfo")
	@ResponseBody
	public String updateInfo(String tid,String email,String phoneNumber){
		String result = stiInf.updateTeacherInfo(tid,email,phoneNumber);
		return result;
	}
	
	@RequestMapping("/checkPassword")
	@ResponseBody
	public String checkPassword(String tid,String oldPwd){
		String result = stiInf.checkPasswordById(tid,oldPwd);
		return result;
	}
	
	@RequestMapping("/updatePassword")
	@ResponseBody
	public String updatePassword(String tid,String newPwd){
		String result = stiInf.updatePasswordById(tid,newPwd);
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
