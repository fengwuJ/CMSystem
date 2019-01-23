package com.mapper.teacher.work;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.pojo.teacher.workpojo.TSWorkRecord;
import com.entity.work.WorkFile;
import com.entity.work.WorkInfo;

public interface TeacherWorkMapper {

	List<WorkInfo> searchWorkInfo(@Param("tid")String tid, @Param("cid")String cid);

	String findCnameByCid(@Param("cid")String cid);

	int searchTotalNumber(@Param("tid")String tid, @Param("cid")String cid);

	void insertWorkInfo(@Param("tid")String tid,@Param("cid")String cid,@Param("subTitle")String subTitle,@Param("subContent")String subContent);

	int checkMul(@Param("tid")String tid, @Param("cid")String cid, @Param("subTitle")String subTitle);

	List<String> findStuIds(@Param("tid")String tid, @Param("cid")String cid);

	int insertWorkFile(@Param("workFile")WorkFile workFile);

	List<TSWorkRecord> searchStuWorkRecord(@Param("tid")String tid, @Param("cid")String cid, @Param("pageSize")int pageSize, @Param("offset")int offset);

	int searchStuWorkRecordTotalNum(@Param("tid")String tid, @Param("cid")String cid);

	String findWorkFileUrl(@Param("sid")String sid, @Param("cid")String cid, @Param("tid")String tid, @Param("workName")String workName);

	void updateCorrctTime(@Param("sid")String sid,@Param("cid")String cid, @Param("tid")String tid, @Param("workName")String workName, @Param("corrctTime")Date date);
}
