package com.jobinterviewer.model;

/**
 * Question model class.
 * Represents an interview question with an id, question text, and answer.
 * Acts as a POJO/DTO for transferring data between the application and database.
 */
public class Question {
	

    // Unique identifier for the question (Primary Key in DB)
	
	private int id;
	
	// The actual interview question text
	
	private String text;
	
	 // The correct or expected answer for the question
	
	private String answer;
	
	 /**
     * Default constructor (no-argument).
     * Useful for frameworks (e.g., Hibernate, JSON parsers).
     */
	
	public Question() {}
	
	public Question(int id,String text,String answer) {
		this.id=id;
		this.text=text;
		this.answer=answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
