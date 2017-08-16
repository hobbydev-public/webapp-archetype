/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.api.web.exceptions;

public class ErrorModel {
	private String message;
	
	public ErrorModel(){}
	
	public ErrorModel(Throwable e) {
		this.message = e.getMessage();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
