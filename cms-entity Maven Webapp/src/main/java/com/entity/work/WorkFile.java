package com.entity.work;

import java.sql.Date;

public class WorkFile {
	private int seqNumber;
	private String fileUrl;
	private Date submitTime;
	private Date correctTime;
	private String sid;
	private String cid;
	private String tid;
	private String status;
	private String workName;
	/**
	 * @return the seqNumber
	 */
	public int getSeqNumber() {
		return seqNumber;
	}
	/**
	 * @return the filrUrl
	 */
	public String getFilrUrl() {
		return fileUrl;
	}
	/**
	 * @return the submitTime
	 */
	public Date getSubmitTime() {
		return submitTime;
	}
	/**
	 * @return the correctTime
	 */
	public Date getCorrectTime() {
		return correctTime;
	}
	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the workName
	 */
	public String getWorkName() {
		return workName;
	}
	/**
	 * @param seqNumber the seqNumber to set
	 */
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	/**
	 * @param filrUrl the filrUrl to set
	 */
	public void setFilrUrl(String filrUrl) {
		this.fileUrl = filrUrl;
	}
	/**
	 * @param submitTime the submitTime to set
	 */
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	/**
	 * @param correctTime the correctTime to set
	 */
	public void setCorrectTime(Date correctTime) {
		this.correctTime = correctTime;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
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
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param workName the workName to set
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	
	

}
