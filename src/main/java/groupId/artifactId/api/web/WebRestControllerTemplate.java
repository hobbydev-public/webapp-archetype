/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.api.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/web")
public class WebRestControllerTemplate {

	@RequestMapping(path="resource", method=RequestMethod.GET)
	public ResponseEntity<Object> getResource() {
		Object resource = new Object();
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(resource, HttpStatus.OK);
		return response;
	}
}
