package com.service.serviceImpl.student.work;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.course.CourseInfo;
import com.entity.pojo.student.coursepojo.MCourseRecord;
import com.entity.pojo.student.coursepojo.TCSRelsp;
import com.entity.pojo.student.workpojo.MWorkRecord;
import com.entity.tcsrelsp.TCSPojo;
import com.entity.userInfo.TeacherInfo;
import com.entity.work.WorkFile;
import com.entity.work.WorkInfo;
import com.mapper.student.work.StuWorkMapper;
import com.service.serviceInterface.student.work.SearchStuWorkRecordServiceInf;
import com.utils.FileUtils;

@Service("sswrsImpl")
public class SearchStuWorkRecordServiceImpl implements SearchStuWorkRecordServiceInf{
	@Resource(name="stuWorkMapper")
	private StuWorkMapper stuWorkMapper;

	@Override
	public List<MWorkRecord> searchWorkRecord(String sid, int pageSize, int offset) {
		// TODO Auto-generated method stub
		List<TCSPojo> tcsPojoList = stuWorkMapper.searchTemp(sid);
		List<WorkInfo> workInfoList = new ArrayList<WorkInfo>();
		for (int i = 0; i < tcsPojoList.size(); i++) {
			List<WorkInfo> list = stuWorkMapper.searchWorkInfo(tcsPojoList.get(i).getTid(),tcsPojoList.get(i).getCid());
			workInfoList.addAll(list);
		}
		
		List<MWorkRecord> mWorkRecordList = new ArrayList<MWorkRecord>();
		for (int i = 0; i < workInfoList.size(); i++) {
			WorkInfo workInfo = workInfoList.get(i);
			WorkFile workFile = stuWorkMapper.searchWorkFile(sid,workInfo.getCid(),workInfo.getTid(),workInfo.getWorkName());
			if (mWorkRecordList.size() == pageSize) {
				break;
			}
			
			if (i >= offset) {
				MWorkRecord mwr = new MWorkRecord();
				mwr.setCid(workFile.getCid());
				mwr.setCname(stuWorkMapper.findCnameByCid(workFile.getCid()));
				mwr.setTname(stuWorkMapper.findTnameByTid(workFile.getTid()));
				mwr.setStatus(workFile.getStatus());
				mwr.setSubmitTime(workFile.getSubmitTime());
				mwr.setWorkName(workFile.getWorkName());
				mwr.setTid(workFile.getTid());
				mWorkRecordList.add(mwr);
			}
		}

		return mWorkRecordList;
		
	}

	@Override
	public int searchTotalNumber(String sid) {
		// TODO Auto-generated method stub
		List<TCSPojo> tcsPojoList = stuWorkMapper.searchTemp(sid);
		int number = 0;
		for (int i = 0; i < tcsPojoList.size(); i++) {
			 int temp = stuWorkMapper.searchTotalNumber(tcsPojoList.get(i).getTid(),tcsPojoList.get(i).getCid());
			 number += temp;
		}
		
		return number;
	}

	/**
	 * @param file 前端上传的文件
	 * @Param workTitle 作业名称
	 * @Param sid	学号
	 * @Param tid	教师编号
	 * @Param cid	课程号
	 * @return 是否上传成功，上传成功或上传失败
	 */
	
	@Override
	public String uploadWorkFile(MultipartFile file, String workTitle, String sid, String tid, String cid) {
		// TODO Auto-generated method stub
		String status = null;
		boolean flag = false;
		Date date = new Date(System.currentTimeMillis());
		String url = "wfile"+File.separator+cid+File.separator+sid;
		String path = FileUtils.createDir(url);
		String fileUrl = path + File.separator + file.getOriginalFilename();
		//检测是否文件重名
		File dirFile = new File(path);
		File[] fs = dirFile.listFiles();
		boolean mul = false;
		if(fs != null){
			for (File f : fs) {
				//若是文件，则将其进行对比
				if (!f.isDirectory()) {
					if (f.getName().equals(file.getOriginalFilename())) {
						mul = true;
					}
				}
			}
		}
		if (mul) {
			status = "文件重名，无法提交";
		}else {
			//开始提交数据
			int cou = stuWorkMapper.updateWorkFile(fileUrl,tid,cid,sid,workTitle,"已提交",date);
			if(cou > 0){
				flag = FileUtils.writeIntoFile(path, file);
			}
			
			if (flag == true && cou > 0) {
				status = "提交成功";
			}else {
				status = "提交失败，请重新提交";
			}
		}
		
		
		return status;
	}
	
}
