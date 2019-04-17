package com.entity.exam;

import java.sql.Date;
import java.sql.Timestamp;

public class ExamInfo {
	private int seqNumber;
	private String examName;
	private String status;
	private Date time;
	private String cid;
	private String tid;
	/**
	 * @return the seqNumber
	 */
	public int getSeqNumber() {
		return seqNumber;
	}
	/**
	 * @return the examName
	 */
	public String getExamName() {
		return examName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}
	
	/**
	 * @return the tid
	 */
	public String getTid() {
		return tid;
	}
	/**
	 * @param seqNumber the seqNumber to set
	 */
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	/**
	 * @param examName the examName to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	/**
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	
}
