package com.controller.teacher.work;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.pojo.teacher.workpojo.TSWorkRecord;
import com.entity.pojo.teacher.workpojo.TWork;
import com.service.serviceInterface.teacher.work.TeacherWorkServiceInf;

@Controller
@RequestMapping("/static/teacherview/mWork")
public class TeachWorkController {
	
	@Resource(name="twsImpl")
	private TeacherWorkServiceInf twsInf;
	
	//教师发布作业记录
	@RequestMapping("/searchTeacherWorks")
	@ResponseBody
	public Map<String, Object> searchTeacherWorks(String tid,String cid,int pageSize,int offset){
		List<TWork> list = twsInf.searchTeacherWorks(tid,cid,pageSize,offset);
		Map<String, Object> map = new HashMap<String, Object>();
		int total = twsInf.searchTotalNumber(tid,cid);
		map.put("total",total);
		map.put("rows", list);
		return map;
	}
	
	//教师发布作业操作
	@RequestMapping("/subWork")
	@ResponseBody
	public String subWork(String tid,String cid,String subTitle,String subContent) {
		String result = twsInf.insertWorkInfo(tid,cid,subTitle,subContent);
		return result;
	}
	
	//该教师下的学生作业记录
	@RequestMapping("/searchStuWorkRecord")
	@ResponseBody
	public Map<String, Object> searchStuWorkRecord(String tid,String cid,int pageSize,int offset){
		List<TSWorkRecord> list = twsInf.searchStuWorkRecord(tid,cid,pageSize,offset);
		Map<String, Object> map = new HashMap<String, Object>();
		int total = twsInf.searchStuWorkRecordTotalNum(tid,cid);
		map.put("total",total);
		map.put("rows", list);
		return map;
	}
	
	//单条记录详情
	@RequestMapping("/searchWorkContent")
	@ResponseBody
	public String searchWorkContent(String tid,String cid,String workName){
		return twsInf.searchWorkContent(tid,cid,workName);
	}
	
	@RequestMapping("/downloadWork")
	@ResponseBody
	public void downloadWork(String sid,String cid,String tid,String workName,HttpServletResponse response){
		twsInf.downloadWork(sid,cid,tid,workName,response);
	}
	
	@RequestMapping("/finish")
	@ResponseBody
	public String finish(String sid,String cid,String tid,String workName) {
		return twsInf.finishWorkScan(sid,cid,tid,workName);
	}
	
	@RequestMapping("/PDFJS/web/preview")
	@ResponseBody
	public void ptrview(String sid,String cid,String tid,String workName,HttpServletResponse response) {
		twsInf.downloadWork(sid, cid, tid, workName, response);
	}
	
}
