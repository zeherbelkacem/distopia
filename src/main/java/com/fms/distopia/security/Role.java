package com.fms.distopia.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author Stagiaires11P
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	private String role;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private List<Uuser> uusers = new ArrayList<Uuser>();

}
