package com.service.serviceInterface.teacher.info;

import com.entity.userInfo.TeacherInfo;

public interface SearchTeacherInfoInf {

	TeacherInfo searchTeacherInfoById(String tid);

	String updateTeacherInfo(String tid, String email, String phoneNumber);

	String checkPasswordById(String tid, String oldPwd);

	String updatePasswordById(String tid, String newPwd);

}
