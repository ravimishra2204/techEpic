package com.restapi.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.company.model.OwnerEntity;

@Repository
public interface OwnerRepo extends JpaRepository<OwnerEntity, Long>{

}
