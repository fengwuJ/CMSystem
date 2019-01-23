package com.mapper.teacher.info;

import org.apache.ibatis.annotations.Param;

import com.entity.userInfo.TeacherInfo;

public interface TeacherInfoMapper {

	TeacherInfo searchTeacherInfo(@Param("tid")String tid);

	void updateTeacherInfo(@Param("tid")String tid, @Param("email")String email, @Param("phoneNumber")String phoneNumber);

	void updatePassword(@Param("tid")String tid,@Param("newPwd")String newPwd);
}
