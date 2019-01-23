package com.entity.login;

public class UserLogin {
	private int seqNumber;
	private String id;
	private String password;
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the seqNumber
	 */
	public int getSeqNumber() {
		return seqNumber;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
}
