/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.api.web.exceptions;

public class HttpBadRequestException extends RuntimeException {
	
	public HttpBadRequestException(String message) {
		super(message);
	}
}
