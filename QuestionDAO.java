package com.jobinterviewer.dao;

import com.jobinterviewer.db.DatabaseConnection;
import com.jobinterviewer.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    // ✅ Insert a new question
    public void saveQuestion(Question question) throws SQLException {
        String sql = "INSERT INTO Question (text, answer) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, question.getText());
            stmt.setString(2, question.getAnswer());
            stmt.executeUpdate();
        }
    }

    // ✅ Fetch all questions
    public List<Question> getAllQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM Question";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                questions.add(new Question(
                        rs.getInt("id"),
                        rs.getString("text"),
                        rs.getString("answer")
                ));
            }
        }
        return questions;
    }

    // ✅ Fetch a question by ID
    public Question getQuestionById(int id) throws SQLException {
        String sql = "SELECT * FROM Question WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Question(
                            rs.getInt("id"),
                            rs.getString("text"),
                            rs.getString("answer")
                    );
                }
            }
        }
        return null;
    }

    // ✅ Update question
    public void updateQuestion(Question question) throws SQLException {
        String sql = "UPDATE Question SET text = ?, answer = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, question.getText());
            stmt.setString(2, question.getAnswer());
            stmt.setInt(3, question.getId());
            stmt.executeUpdate();
        }
    }

    // ✅ Delete question by ID
    public void deleteQuestion(int id) throws SQLException {
        String sql = "DELETE FROM Question WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
