package com.entity.exam;

public class StuExamShortAnswer {
	private int seqNumber;
	private String examName;
	private String sid;
	private String a1;
	private String a2;
	private String a3;
	private int shortAnswerGoal;
	
	public int getShortAnswerGoal() {
		return shortAnswerGoal;
	}
	public void setShortAnswerGoal(int shortAnswerGoal) {
		this.shortAnswerGoal = shortAnswerGoal;
	}
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
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @return the a1
	 */
	public String getA1() {
		return a1;
	}
	/**
	 * @return the a2
	 */
	public String getA2() {
		return a2;
	}
	/**
	 * @return the a3
	 */
	public String getA3() {
		return a3;
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
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
	/**
	 * @param a1 the a1 to set
	 */
	public void setA1(String a1) {
		this.a1 = a1;
	}
	/**
	 * @param a2 the a2 to set
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	/**
	 * @param a3 the a3 to set
	 */
	public void setA3(String a3) {
		this.a3 = a3;
	}
	
	
}
