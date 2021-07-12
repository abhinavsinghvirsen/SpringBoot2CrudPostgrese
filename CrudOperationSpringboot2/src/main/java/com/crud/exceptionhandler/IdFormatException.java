package com.crud.exceptionhandler;

public class IdFormatException extends Exception{
	
	String id;
	String discription;
	
	public IdFormatException(String id, String discription) {
		super();
		this.id = id;
		this.discription = discription;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	

}
