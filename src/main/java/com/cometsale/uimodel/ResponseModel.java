package com.cometsale.uimodel;

public class ResponseModel {
	
	String ErrorMessage;
	boolean status;

	public ResponseModel(){
		
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setDefaultValue() {
		this.ErrorMessage ="not succesful";
		this.status = false;
		
	}

}
