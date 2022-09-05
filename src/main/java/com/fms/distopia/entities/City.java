package com.fms.distopia.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Stagiaires11P
 *
 */


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3)
	private String name;
	
	@NotNull
	private Integer department;
	
	
	@OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
	private List<Cinema> cinemas = new ArrayList<Cinema>();
}
