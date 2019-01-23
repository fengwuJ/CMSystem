package com.service.serviceImpl.teacher.info;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.userInfo.TeacherInfo;
import com.mapper.UserMapper;
import com.mapper.teacher.info.TeacherInfoMapper;
import com.service.serviceInterface.teacher.info.SearchTeacherInfoInf;

@Service("stisImpl")
public class SearchTeacherInfoServiceImpl implements SearchTeacherInfoInf {
	@Resource(name="teacherInfoMapper")
	private TeacherInfoMapper teacherInfoMapper;
	
	@Resource(name="userMapper") 
	private UserMapper userMapper;
	
	
	@Override
	public TeacherInfo searchTeacherInfoById(String tid) {
		// TODO Auto-generated method stub
		TeacherInfo teacherInfo = teacherInfoMapper.searchTeacherInfo(tid);
		return teacherInfo;
	}


	@Override
	public String updateTeacherInfo(String tid, String email, String phoneNumber) {
		// TODO Auto-generated method stub
		teacherInfoMapper.updateTeacherInfo(tid,email,phoneNumber);
		return "修改成功";
	}


	@Override
	public String checkPasswordById(String tid, String oldPwd) {
		// TODO Auto-generated method stub
		String dbPassword = userMapper.findPasswordByTeachId(tid);
		String result = null;
		if(dbPassword.equals(oldPwd)){
			result = "旧密码输入正确";
		}else {
			result = "旧密码输入错误，请重新输入";
		}
		return result;
	}


	@Override
	public String updatePasswordById(String tid, String newPwd) {
		// TODO Auto-generated method stub
		teacherInfoMapper.updatePassword(tid, newPwd);
		return "修改成功";
	}


}
