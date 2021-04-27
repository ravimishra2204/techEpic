package com.restapi.company.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.restapi.company.controller.CompanyController;
import com.restapi.company.model.CompanyEntity;
import com.restapi.company.model.OwnerEntity;

@ExtendWith (SpringExtension.class)
@WebMvcTest(value = CompanyController.class)
@AutoConfigureMockMvc
public class CompanyServiceTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CompanyService srv;
	@MockBean
	private CompanyController cntrller;
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
    private TestRestTemplate restTemplate;
	
	  @LocalServerPort
	     private int port;

	     private String getRootUrl() {
	         return "http://localhost:" + port;
	     }

	  @Test
	     public void contextLoads() {

	     }
	  
	  @Test
	     public void testGetAllEmployees() {
	     HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/getCompanies",
	        HttpMethod.GET, entity, String.class);  
	        assertNotNull(response.getBody());
	    }

			/*
			 * @Test public void testAddComp() throws Exception{
			 * 
			 * CompanyEntity mockEntity = new CompanyEntity(); mockEntity.setId(1L);
			 * mockEntity.setCompName("scb"); mockEntity.setCountry("India");
			 * mockEntity.setId(1L); mockEntity.setPhNo("123");
			 * 
			 * 
			 * try { mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
			 * ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter(); String
			 * pageInfoJson = writer.writeValueAsString(mockEntity);
			 * mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addCompany").content(
			 * pageInfoJson)
			 * .contentType(MediaType.APPLICATION_JSON).andExpect(MockMvcResultMatchers.
			 * status().isOk())
			 * .andExpect(MockMvcResultMatchers.content().contentType(MediaType.
			 * APPLICATION_JSON))); }catch(Exception ex) { throw ex; } }
			 * 
			 * 
			 * 
			 * @Test public void getCompanies() throws Exception{
			 * 
			 * CompanyEntity mockEntity = new CompanyEntity();
			 */
	  
	  
	  
	  


}
