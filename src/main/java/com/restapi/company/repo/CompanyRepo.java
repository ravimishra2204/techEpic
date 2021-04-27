package com.restapi.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.company.model.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Long>{

}
