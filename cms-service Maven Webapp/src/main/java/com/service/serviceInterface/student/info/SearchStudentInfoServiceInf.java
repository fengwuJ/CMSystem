package com.service.serviceInterface.student.info;

import com.entity.userInfo.StudentInfo;

public interface SearchStudentInfoServiceInf {
	//通过学生id找到学生信息
	public StudentInfo searchStudentInfoById(String sid);

	public String updatePhoneNumberById(String sid, String phoneNumber);

	public String checkPwsswordById(String sid, String oldPwd);

	public String updatePwsswordById(String sid, String newPwd);
}
