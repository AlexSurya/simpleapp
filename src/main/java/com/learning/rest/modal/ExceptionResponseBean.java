package com.learning.rest.modal;

import java.util.Date;

public class ExceptionResponseBean {

	private Date timestamp_;
	private String message_;
	private String details_;
	
	public ExceptionResponseBean(Date timestamp_, String message_, String details_) {
		super();
		this.timestamp_ = timestamp_;
		this.message_ = message_;
		this.details_ = details_;
	}

	public Date getTimestamp_() {
		return timestamp_;
	}

	public void setTimestamp_(Date timestamp_) {
		this.timestamp_ = timestamp_;
	}

	public String getMessage_() {
		return message_;
	}

	public void setMessage_(String message_) {
		this.message_ = message_;
	}

	public String getDetails_() {
		return details_;
	}

	public void setDetails_(String details_) {
		this.details_ = details_;
	}
	
	
}
