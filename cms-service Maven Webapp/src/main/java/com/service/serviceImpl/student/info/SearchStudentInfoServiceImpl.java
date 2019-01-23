package com.service.serviceImpl.student.info;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.userInfo.StudentInfo;
import com.mapper.UserMapper;
import com.mapper.student.info.StuInfoMapper;
import com.service.serviceInterface.student.info.SearchStudentInfoServiceInf;

@Service("searchStuInfoServImpl")
public class SearchStudentInfoServiceImpl implements SearchStudentInfoServiceInf{

	@Resource(name="stuInfoMapper")
	private StuInfoMapper stuInfoMapper;
	
	@Resource(name="userMapper") 
	private UserMapper userMapper;
	
	
	@Override
	public StudentInfo searchStudentInfoById(String sid) {
		// TODO Auto-generated method stub
		StudentInfo studentInfo = stuInfoMapper.searchStudentInfo(sid);
		return studentInfo;
	}


	@Override
	public String updatePhoneNumberById(String sid, String phoneNumber) {
		// TODO Auto-generated method stub
		stuInfoMapper.updatePhoneNumber(sid,phoneNumber);
		return "修改成功";
	}


	@Override
	public String checkPwsswordById(String sid, String oldPwd) {
		// TODO Auto-generated method stub
		String dbPassword = userMapper.findPasswordByStuId(sid);
		String result = null;
		if(dbPassword.equals(oldPwd)){
			result = "旧密码输入正确";
		}else {
			result = "旧密码输入错误，请重新输入";
		}
		return result;
	}


	@Override
	public String updatePwsswordById(String sid, String newPwd) {
		// TODO Auto-generated method stub
		stuInfoMapper.updatePwssword(sid,newPwd);
		return "修改成功";
	}

}
