/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.api.web.exceptions.handlers;
		
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import groupId.artifactId.api.web.exceptions.ErrorModel;
import groupId.artifactId.api.web.exceptions.HttpBadRequestException;
import groupId.artifactId.business.exception.ResourceForbiddenOperationException;
import groupId.artifactId.business.exception.ResourceNotFoundException;

@ControllerAdvice(annotations = {RestController.class})
public class WebRestControllerExceptionsHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<ErrorModel> handleAccessDeniedException() {
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler({HttpBadRequestException.class})
	public ResponseEntity<ErrorModel> handleBadRequestException(Exception e) {
		return new ResponseEntity<>(new ErrorModel(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<ErrorModel> handleNotFoundException(Exception e) {
		return new ResponseEntity<>(new ErrorModel(e), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ResourceForbiddenOperationException.class})
	public ResponseEntity<ErrorModel> handleForbiddenException(Exception e) {
		return new ResponseEntity<>(new ErrorModel(e), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler({UsernameNotFoundException.class})
	public ResponseEntity<ErrorModel> handleUsernameNotFoundException(Exception e) {
		return new ResponseEntity<>(new ErrorModel(e), HttpStatus.NOT_FOUND);
	}
}
