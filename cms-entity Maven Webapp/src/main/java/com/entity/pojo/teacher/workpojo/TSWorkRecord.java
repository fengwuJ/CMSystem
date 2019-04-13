package com.entity.pojo.teacher.workpojo;

import java.sql.Date;

public class TSWorkRecord {
	private int seqNumber;
	private String sid;
	private String sname;
	private String title;
	private Date time;
	private String status;
	private Date ctime;
	
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public int getSeqNumber() {
		return seqNumber;
	}
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
