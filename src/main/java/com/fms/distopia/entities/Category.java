package com.fms.distopia.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author Stagiaires11P
 *
 */

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Movie> movies = new ArrayList<Movie>();
}
