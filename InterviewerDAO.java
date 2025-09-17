package com.jobinterviewer.dao;

import com.jobinterviewer.db.DatabaseConnection;
import com.jobinterviewer.model.Interviewer;

import java.sql.*;

public class InterviewerDAO {

    public Interviewer login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Interviewer WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Interviewer(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        }
        return null;
    }

    public void addInterviewer(String username, String password) throws SQLException {
        String sql = "INSERT INTO Interviewer(username, password) VALUES(?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        }
    }
}
