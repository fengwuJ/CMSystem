package com.controller.student.work;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.pojo.student.workpojo.MWorkRecord;
import com.service.serviceInterface.student.work.SearchStuWorkRecordServiceInf;

@Controller
@RequestMapping("/static/studentview/mWork")
public class StuWorkController {
	@Resource(name="sswrsImpl")
	private SearchStuWorkRecordServiceInf sswrsInf;
	
	@RequestMapping("/searchWorkRecord")
	@ResponseBody
	public Map<String, Object> searchWorkRecord(String sid,int pageSize,int offset){
		List<MWorkRecord> list = sswrsInf.searchWorkRecord(sid,pageSize,offset);
		Map<String, Object> map = new HashMap<String, Object>();
		int total = sswrsInf.searchTotalNumber(sid);
		map.put("total",total);
		map.put("rows", list);
		return map;
	}
	
	//作业上传
	@RequestMapping("/uploadWorkFile")
	@ResponseBody
	public String uploadWorkFile(@RequestParam(value = "file", required = false)MultipartFile file,String workTitle,String sid,String tid,String cid) {
		String result = sswrsInf.uploadWorkFile(file,workTitle,sid,tid,cid);
		return result;
	}
	
	
}
