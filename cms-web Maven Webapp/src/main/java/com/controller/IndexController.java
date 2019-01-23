package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.course.CourseInfo;
import com.mapper.UserMapper;
@Controller
public class IndexController {
	
	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("/")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String toRegister() {
		return "/studentview/stu_main";
	}
	
	
	@RequestMapping("/main")
	public String toMain(String userId,String password,Integer identify,HttpServletRequest request,Model model) {
		String nextUrl = "login";
		String username = null;
		HttpSession session = null;
		
		if (identify == null) {
			return "myRedirect";
		}
		
		//学生身份
		if (identify == 0 && userMapper.checkExistByStuId(userId)) {
			String dbPassword = userMapper.findPasswordByStuId(userId);
			//加密待做
			if (dbPassword.equals(password)) {
				username = userMapper.findStudentNameById(userId);
				nextUrl = "/studentview/stu_main";
			}
		}
		
		//教师身份
		if (identify == 1 && userMapper.checkExistByTeachId(userId)) {
			String dbPassword = userMapper.findPasswordByTeachId(userId);
			//加密待做
			if (dbPassword.equals(password)) {
				username = userMapper.findTeacherNameById(userId);
				nextUrl =  "/teacherview/teacher_main";
			}
		}
		
		session = request.getSession();
		session.setAttribute("userId",userId);
		session.setAttribute("userName",username);
		model.addAttribute("uid",userId);
		model.addAttribute("uname",username);
		
		return nextUrl;
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
	
	@RequestMapping("/searchMyCourse")
	@ResponseBody
	public Map<String, Object> searchMyCourse(String tid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CourseInfo> list = userMapper.getMyCourse(tid);
		map.put("list", list);
		return map;
	}
	
}
