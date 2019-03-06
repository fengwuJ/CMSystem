package com.entity.exam;

import java.io.Serializable;

public class SingleChoice implements Serializable{
	private int seqNumber;
	private String title;
	private String aOption;
	private String bOption;
	private String cOption;
	private String dOption;
	private char rightChoice;
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
	 * @return the aOption
	 */
	public String getaOption() {
		return aOption;
	}
	/**
	 * @return the bOption
	 */
	public String getbOption() {
		return bOption;
	}
	/**
	 * @return the cOption
	 */
	public String getcOption() {
		return cOption;
	}
	/**
	 * @return the dOption
	 */
	public String getdOption() {
		return dOption;
	}
	/**
	 * @return the rightChoice
	 */
	public char getRightChoice() {
		return rightChoice;
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
	 * @param aOption the aOption to set
	 */
	public void setaOption(String aOption) {
		this.aOption = aOption;
	}
	/**
	 * @param bOption the bOption to set
	 */
	public void setbOption(String bOption) {
		this.bOption = bOption;
	}
	/**
	 * @param cOption the cOption to set
	 */
	public void setcOption(String cOption) {
		this.cOption = cOption;
	}
	/**
	 * @param dOption the dOption to set
	 */
	public void setdOption(String dOption) {
		this.dOption = dOption;
	}
	/**
	 * @param rightChoice the rightChoice to set
	 */
	public void setRightChoice(char rightChoice) {
		this.rightChoice = rightChoice;
	}
	
	
}
