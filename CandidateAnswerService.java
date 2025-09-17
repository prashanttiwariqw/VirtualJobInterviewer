package com.jobinterviewer.service;

import com.jobinterviewer.dao.CandidateAnswerDAO;
import com.jobinterviewer.model.CandidateAnswer;

import java.sql.SQLException;
import java.util.List;

public class CandidateAnswerService {
    private final CandidateAnswerDAO dao = new CandidateAnswerDAO();

    public void saveAnswer(CandidateAnswer answer) throws SQLException {
        dao.saveAnswer(answer);
    }

    public List<CandidateAnswer> getCandidateAnswers(int candidateId) throws SQLException {
        return dao.getAnswersByCandidate(candidateId);
    }
}
