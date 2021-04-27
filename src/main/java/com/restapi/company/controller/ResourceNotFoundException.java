package com.restapi.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ResponseStatusException {
	
	public ResourceNotFoundException (HttpStatus status) {
		super(status);
	}

	public ResourceNotFoundException (HttpStatus status,String reason) {
		super(status,reason);
	}
	
}
