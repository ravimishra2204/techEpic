package com.restapi.company.service;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.restapi.company.controller.ResourceNotFoundException;
import com.restapi.company.model.CompanyEntity;
import com.restapi.company.model.OwnerEntity;
import com.restapi.company.repo.CompanyRepo;
import com.restapi.company.repo.OwnerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyService {
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired 
	private OwnerRepo ownerRepo;
	
	public ResponseEntity<String> addCompany(CompanyEntity entity){
	try {
		 entity = companyRepo.save(entity);
			log.debug("created with id :"+entity.getId());
			return new ResponseEntity<String>("Success --> Company entry added",HttpStatus.OK);
	}catch(Exception ex) {
		ex.getStackTrace();
		log.error("error creating while stroring company details"+ex.getMessage()+"---"+ex.getCause());
		return new ResponseEntity<String>("Failure",HttpStatus.BAD_REQUEST);
	}
	}
	
	public ResponseEntity<List<CompanyEntity>> getCompanies (){
		
		try {
			List<CompanyEntity> companies = companyRepo.findAll();
			if(companies.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<> (companies,HttpStatus.OK);
		}
		catch(Exception ex) {
			log.error("Internal server error");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public CompanyEntity getCompany (@RequestParam Long id){
		
		return companyRepo.findById(id).map(comp->{
			return comp;
			})
				.orElseThrow(()-> new ResourceNotFoundException(HttpStatus.BAD_REQUEST,"input company id not found"));
	}
	
	public OwnerEntity addOwner (@RequestParam Long id, @Valid @RequestBody OwnerEntity owner){
		
		return companyRepo.findById(id).map(comp->{
			owner.setCompany(comp);
			return ownerRepo.save(owner);
			})
				.orElseThrow(()-> new ResourceNotFoundException(HttpStatus.BAD_REQUEST,"input company id not found to add a owner"));
}
	
public CompanyEntity updateCompany (@RequestParam Long id, @Valid @RequestBody CompanyEntity entity){
		
	return companyRepo.findById(id).map(comp->{
		comp.setCompName(entity.getCompName());
		comp.setCountry(entity.getCountry());
		comp.setPhNo(entity.getPhNo());
		comp.setOwners(entity.getOwners());
		return companyRepo.save(comp);
		})
			.orElseThrow(()-> new ResourceNotFoundException(HttpStatus.BAD_REQUEST,"input company id not found got update"));
}

public Boolean validateSsn(String ssn) {
	return simulateSsn();
}

private boolean simulateSsn() {
	Random random = new Random();
	return random.nextBoolean();
	
	
}
}
