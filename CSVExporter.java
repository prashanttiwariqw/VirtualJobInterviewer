package com.jobinterviewer.util;

import com.jobinterviewer.model.CandidateAnswer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static void exportCandidateAnswers(String filePath, List<CandidateAnswer> answers) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write CSV Header
            writer.append("AnswerID,CandidateID,QuestionID,Answer,Correct\n");

            // Write each answer
            for (CandidateAnswer ans : answers) {
                writer.append(String.valueOf(ans.getId())).append(",");
                writer.append(String.valueOf(ans.getCandidateId())).append(",");
                writer.append(String.valueOf(ans.getQuestionId())).append(",");
                writer.append(ans.getAnswer().replace(",", ";")).append(","); // replace commas inside answers
                writer.append(String.valueOf(ans.isCorrect())).append("\n");
            }
        }
    }
}
