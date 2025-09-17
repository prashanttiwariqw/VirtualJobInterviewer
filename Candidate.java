package com.jobinterviewer.model;

/**
 * Candidate model class.
 * Represents a candidate entity with id, name, and email.
 * This class is typically used to transfer data between
 * the application and the database (DTO/POJO).
 */

public class Candidate {
	 // Unique identifier for the candidate (Primary Key in DB)
	private int id;
	 // Candidate's full name
	private String name;
	 // Candidate's email address
	private String email;
	
	/**
     * Default constructor (no-argument).
     * Useful for frameworks or libraries that require it (e.g., Hibernate, JSON parsers).
     */
	
	public Candidate() {}
	
	public Candidate(int id,String name,String email) {
		this.id=id;
		this.name=name;
		this.email=email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
