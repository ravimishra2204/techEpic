package com.restapi.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter @Entity
@Table(name ="owner")
public class OwnerEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name ="";
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "company_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private CompanyEntity company;
	private String ssnNo ="";

}
