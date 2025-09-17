package com.jobinterviewer.dao;

import com.jobinterviewer.db.DatabaseConnection;
import com.jobinterviewer.model.CandidateAnswer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateAnswerDAO {

    public void saveAnswer(CandidateAnswer answer) throws SQLException {
        String sql = "INSERT INTO Candidate_Answer(candidate_id, question_id, answer, is_correct) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, answer.getCandidateId());
            stmt.setInt(2, answer.getQuestionId());
            stmt.setString(3, answer.getAnswer());
            stmt.setBoolean(4, answer.isCorrect());
            stmt.executeUpdate();
        }
    }

    public List<CandidateAnswer> getAnswersByCandidate(int candidateId) throws SQLException {
        String sql = "SELECT * FROM Candidate_Answer WHERE candidate_id = ?";
        List<CandidateAnswer> answers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, candidateId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                answers.add(new CandidateAnswer(
                        rs.getInt("id"),
                        rs.getInt("candidate_id"),
                        rs.getInt("question_id"),
                        rs.getString("answer"),
                        rs.getBoolean("is_correct")
                ));
            }
        }
        return answers;
    }
}
