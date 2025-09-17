package com.jobinterviewer.dao;

import com.jobinterviewer.db.DatabaseConnection;
import com.jobinterviewer.model.Candidate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    // ✅ Insert candidate (Register)
    public void saveCandidate(Candidate candidate) throws SQLException {
        String sql = "INSERT INTO Candidate (name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, candidate.getName());
            stmt.setString(2, candidate.getEmail());
            stmt.executeUpdate();

            // Set generated ID back to candidate object
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    candidate.setId(rs.getInt(1));
                }
            }
        }
    }

    // ✅ Fetch all candidates
    public List<Candidate> getAllCandidates() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        String sql = "SELECT * FROM Candidate";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                candidates.add(new Candidate(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
        }
        return candidates;
    }

    // ✅ Fetch candidate by ID
    public Candidate getCandidateById(int id) throws SQLException {
        String sql = "SELECT * FROM Candidate WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Candidate(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
            }
        }
        return null;
    }

    // ✅ Update candidate details
    public void updateCandidate(Candidate candidate) throws SQLException {
        String sql = "UPDATE Candidate SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, candidate.getName());
            stmt.setString(2, candidate.getEmail());
            stmt.setInt(3, candidate.getId());
            stmt.executeUpdate();
        }
    }

    // ✅ Delete candidate by ID
    public void deleteCandidate(int id) throws SQLException {
        String sql = "DELETE FROM Candidate WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
