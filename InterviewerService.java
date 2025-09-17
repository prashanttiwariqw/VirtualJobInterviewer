package com.jobinterviewer.service;

import com.jobinterviewer.dao.InterviewerDAO;
import com.jobinterviewer.dao.QuestionDAO;
import com.jobinterviewer.model.Interviewer;
import com.jobinterviewer.model.Question;

import java.sql.SQLException;
import java.util.List;

public class InterviewerService {
    private final InterviewerDAO interviewerDAO = new InterviewerDAO();
    private final QuestionDAO questionDAO = new QuestionDAO();

    public Interviewer login(String username, String password) throws SQLException {
        return interviewerDAO.login(username, password);
    }

    public void addQuestion(String text, String answer) throws SQLException {
        Question q = new Question(0, text, answer);
        questionDAO.saveQuestion(q);
    }

    public void updateQuestion(int id, String text, String answer) throws SQLException {
        Question q = new Question(id, text, answer);
        questionDAO.updateQuestion(q);
    }

    public void deleteQuestion(int id) throws SQLException {
        questionDAO.deleteQuestion(id);
    }

    public List<Question> getAllQuestions() throws SQLException {
        return questionDAO.getAllQuestions();
    }
}
