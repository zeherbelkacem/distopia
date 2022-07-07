package com.fms.distopia.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Address {
	
	
	@NotNull
	@Size(min = 4)
	private String address1;
	
	private String address2;

	@NotNull
	@Size(min = 3)
	private String town;
	
	private String codeZip;
	
	private String country;

}
