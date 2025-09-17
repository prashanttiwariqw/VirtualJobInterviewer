package com.jobinterviewer.model;

public class CandidateAnswer {
    private int id;
    private int candidateId;
    private int questionId;
    private String answer;
    private boolean isCorrect;

    public CandidateAnswer() {}

    public CandidateAnswer(int id, int candidateId, int questionId, String answer, boolean isCorrect) {
        this.id = id;
        this.candidateId = candidateId;
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
    
}

