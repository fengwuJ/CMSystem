package com.entity.exam;

import java.io.Serializable;

public class ShortAnswer implements Serializable{
	private int seqNumber;
	private String title;
	private String answer;
	/**
	 * @return the seqNumber
	 */
	public int getSeqNumber() {
		return seqNumber;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param seqNumber the seqNumber to set
	 */
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
