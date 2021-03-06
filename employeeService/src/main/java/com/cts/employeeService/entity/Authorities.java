package com.cts.employeeService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Authorities implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7794735684718733582L;
	
	@Id
	@Column(insertable = true ,name = "username", length=100)
	private String username;
	
	@Id
	@Column(insertable = true ,name = "authority",length=100)
	private String authority;

}
