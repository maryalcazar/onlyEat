package org.learning.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "CLIENTE")
public class Client implements Serializable {
	private static final long serialVersionUID = -2143308097217497631L;
	private Integer id;
	private String email;
	private String password;
	
	public Client() {
		//Empty constructor
	}

	public Client(Integer id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "EMAIL", length = 15, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PWD", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		try {
			//TODO Avoid recreate ObjectMapper again and again
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			//TODO Log this
			return super.toString();
		}
	}
}
