package com.jval.common.exception;

public class ValidateException extends Exception {

	private static final long serialVersionUID = 9195234595524278515L;
	
	private String errCode;
	
	public ValidateException(String msg){
		super(msg);
	}
	
	public ValidateException(String msg, Exception ex){
		super(msg,ex);
	}
	
	public ValidateException(String errCode,String msg){
		super(msg);
	}
	
	public ValidateException(String errCode,String msg, Exception ex){
		super(msg,ex);
		this.setErrCode(errCode);
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
}
