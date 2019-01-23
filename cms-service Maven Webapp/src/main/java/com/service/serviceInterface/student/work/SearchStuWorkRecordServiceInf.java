package com.service.serviceInterface.student.work;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.entity.pojo.student.workpojo.MWorkRecord;

public interface SearchStuWorkRecordServiceInf {

	List<MWorkRecord> searchWorkRecord(String sid, int pageSize, int offset);

	int searchTotalNumber(String sid);

	String uploadWorkFile(MultipartFile file, String workTitle, String sid, String tid, String cid);

}
