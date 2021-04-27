package com.restapi.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
	
	// Generic Exception handler for input validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
		log.error("inside generic ex handler block");
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		Map<String,String> map = new HashMap<>(errors.size());
		errors.forEach((error) -> {
			String key = ((FieldError)error).getField();
			String value = error.getDefaultMessage();
			map.put(key, value);
		});
		return ResponseEntity.badRequest().body(map);
	}

}
