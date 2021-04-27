/**
 * 
 */
package com.restapi.company.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.company.model.CompanyEntity;
import com.restapi.company.model.OwnerEntity;
import com.restapi.company.repo.CompanyRepo;
import com.restapi.company.repo.OwnerRepo;
import com.restapi.company.service.CompanyService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.*;

/**
 * @author ravimishra
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@ApiOperation("API -> to add a company")
	@PostMapping("/addCompany")
	public ResponseEntity<String> addCompany (@Valid @RequestBody CompanyEntity entity){
		log.info("insidenaddCompany method"+entity);

		
	 return service.addCompany(entity);
	 
	}

	@ApiOperation("API -> to get list of companies")
	@GetMapping("/getCompanies")
	public ResponseEntity<List<CompanyEntity>> getCompanies (){
			return service.getCompanies();
		
	}
	@ApiOperation("API -> to get a company by id")
	@GetMapping("/getCompany")
	public CompanyEntity getCompany (@RequestParam Long id){
		
			return service.getCompany(id);
	}
	
	@ApiOperation("API -> to add a owner under a company")
	@PostMapping("/addOwner")
	public OwnerEntity addOwner (@RequestParam Long id, @Valid @RequestBody OwnerEntity owner){
		
			return service.addOwner(id, owner);
	}
	
	@ApiOperation("API -> to update an existing company")
	@PutMapping("/updateCompany")
	public CompanyEntity updateCompany (@RequestParam Long id, @Valid @RequestBody CompanyEntity entity){
		
			return service.updateCompany(id, entity);
	}
	
	@ApiOperation("API -> to validity of ssn No")
	@GetMapping("/validateSSN")
	public Boolean validateSSN (@RequestParam String ssn ){
		
			return service.validateSsn(ssn);
	}

	
}
