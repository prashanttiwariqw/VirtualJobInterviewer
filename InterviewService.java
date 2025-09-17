package com.jobinterviewer.service;

import com.jobinterviewer.dao.CandidateDAO;
import com.jobinterviewer.dao.QuestionDAO;
import com.jobinterviewer.model.Candidate;
import com.jobinterviewer.model.Question;

import java.sql.SQLException;
import java.util.List;

/**
 * Service layer for handling interview-related operations.
 * Acts as a bridge between the UI/Controller and the DAO layer.
 * 
 * Responsibilities:
 *  - Manage candidate registration
 *  - Retrieve interview questions
 */
public class InterviewService {

    // Data Access Objects (DAO) for database interactions
    private final CandidateDAO candidateDAO = new CandidateDAO();
    private final QuestionDAO questionDAO = new QuestionDAO();

    /**
     * Registers a new candidate by creating a Candidate object
     * and saving it into the database.
     * 
     * @param name candidate's name
     * @param email candidate's email
     * @throws SQLException if a database access error occurs
     */
    public void registerCandidate(String name, String email) throws SQLException {
        // id is set to 0 initially, assuming the DB will auto-generate it
        Candidate candidate = new Candidate(0, name, email);
        candidateDAO.saveCandidate(candidate);
    }

    /**
     * Fetches all available interview questions from the database.
     * 
     * @return a list of questions
     * @throws SQLException if a database access error occurs
     */
    public List<Question> fetchQuestions() throws SQLException {
        return questionDAO.getAllQuestions();
    }
}
