/**
 * 
 */
package com.restapi.company.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

import lombok.*;

/**
 * @author ravimishra
 *
 */
@Getter @Setter
@Entity @Table(name ="company")
public class CompanyEntity {
	
//	public CompanyEntity(Long id, @NotNull @NotEmpty String compName, @NotNull @NotEmpty String country,
//			@NotNull @NotEmpty String phNo, Set<OwnerEntity> owners) {
//		super();
//		this.id = id;
//		this.compName = compName;
//		this.country = country;
//		this.phNo = phNo;
//		this.owners = owners;
//	}


	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String compName ="";
	@NotNull @NotEmpty
	private String country ="";
	@NotNull @NotEmpty
	private String phNo ="";
	 @OneToMany(mappedBy = "company",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	 
    private Set<OwnerEntity> owners = new HashSet<>();
	 

	public void setOwners(Set<OwnerEntity> owners) {
		this.owners = owners;
		for(OwnerEntity ownEnty: owners) {
			ownEnty.setCompany(this);
		}
	}

}
