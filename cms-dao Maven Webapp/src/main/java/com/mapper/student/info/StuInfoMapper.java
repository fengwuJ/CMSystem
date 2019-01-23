package com.mapper.student.info;

import org.apache.ibatis.annotations.Param;

import com.entity.userInfo.StudentInfo;

public interface StuInfoMapper {
	public StudentInfo searchStudentInfo(@Param("sid")String sid);

	public void updatePhoneNumber(@Param("sid")String sid, @Param("phoneNumber")String phoneNumber);

	public void updatePwssword(@Param("sid")String sid, @Param("newPwd")String newPwd);
	
}
