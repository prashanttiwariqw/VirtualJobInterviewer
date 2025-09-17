package com.jobinterviewer.ui;

import com.jobinterviewer.model.Candidate;
import com.jobinterviewer.model.CandidateAnswer;
import com.jobinterviewer.model.Interviewer;
import com.jobinterviewer.model.Question;
import com.jobinterviewer.service.InterviewerService;
import com.jobinterviewer.util.CSVExporter;
import com.jobinterviewer.dao.CandidateDAO;
import com.jobinterviewer.dao.CandidateAnswerDAO;

import java.util.List;
import java.util.Scanner;

public class InterviewerUI {
    private final InterviewerService service = new InterviewerService();
    private final CandidateDAO candidateDAO = new CandidateDAO();
    private final CandidateAnswerDAO answerDAO = new CandidateAnswerDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            Interviewer interviewer = service.login(username, password);
            if (interviewer == null) {
                System.out.println("Invalid credentials!");
                return;
            }

            System.out.println("✅ Login successful!");

            while (true) {
                System.out.println("\n=== Interviewer Menu ===");
                System.out.println("1. Add Question");
                System.out.println("2. Update Question");
                System.out.println("3. Delete Question");
                System.out.println("4. View Questions");
                System.out.println("5. View Candidates");
                System.out.println("6. View Candidate Answers");
                System.out.println("7. Logout");
                System.out.println("8. Export Candidate Results");
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter question: ");
                        String qText = scanner.nextLine();
                        System.out.print("Enter answer: ");
                        String qAns = scanner.nextLine();
                        service.addQuestion(qText, qAns);
                        System.out.println("✅ Question added.");
                        break;

                    case 2:
                        System.out.print("Enter question ID to update: ");
                        int qId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new text: ");
                        String newText = scanner.nextLine();
                        System.out.print("Enter new answer: ");
                        String newAns = scanner.nextLine();
                        service.updateQuestion(qId, newText, newAns);
                        System.out.println("✅ Question updated.");
                        break;

                    case 3:
                        System.out.print("Enter question ID to delete: ");
                        int delId = Integer.parseInt(scanner.nextLine());
                        service.deleteQuestion(delId);
                        System.out.println("✅ Question deleted.");
                        break;

                    case 4:
                        List<Question> questions = service.getAllQuestions();
                        if (questions.isEmpty()) {
                            System.out.println("⚠️ No questions available.");
                        } else {
                            System.out.println("\n--- Questions ---");
                            for (Question q : questions) {
                                System.out.println(q.getId() + ". " + q.getText() + " (Ans: " + q.getAnswer() + ")");
                            }
                        }
                        break;

                    case 5:
                        List<Candidate> candidates = candidateDAO.getAllCandidates();
                        if (candidates.isEmpty()) {
                            System.out.println("⚠️ No candidates registered.");
                        } else {
                            System.out.println("\n--- Candidates ---");
                            for (Candidate c : candidates) {
                                System.out.println(c.getId() + ". " + c.getName() + " (" + c.getEmail() + ")");
                            }
                        }
                        break;

                    case 6:
                        System.out.print("Enter candidate ID to view answers: ");
                        int candidateId = Integer.parseInt(scanner.nextLine());
                        List<CandidateAnswer> answers = answerDAO.getAnswersByCandidate(candidateId);

                        if (answers.isEmpty()) {
                            System.out.println("⚠️ No answers found for this candidate.");
                        } else {
                            System.out.println("\n--- Candidate Answers ---");
                            int score = 0;
                            for (CandidateAnswer ans : answers) {
                                System.out.println("QID: " + ans.getQuestionId() +
                                        " | Answer: " + ans.getAnswer() +
                                        " | Correct: " + ans.isCorrect());
                                if (ans.isCorrect()) score++;
                            }
                            System.out.println("✅ Score: " + score + "/" + answers.size());
                        }
                        break;

                    case 7:
                        System.out.println("🔒 Logged out.");
                        return;
                        
                    case 8:
                        System.out.print("Enter candidate ID to export results: ");
                        int exportCandidateId = Integer.parseInt(scanner.nextLine());

                        List<CandidateAnswer> exportAnswers = answerDAO.getAnswersByCandidate(exportCandidateId);

                        if (exportAnswers.isEmpty()) {
                            System.out.println("⚠️ No answers found for this candidate.");
                        } else {
                            System.out.print("Enter file path to save CSV (e.g., candidate_results.csv): ");
                            String filePath = scanner.nextLine();

                            try {
                                CSVExporter.exportCandidateAnswers(filePath, exportAnswers);
                                System.out.println("✅ Candidate results exported to " + filePath);
                            } catch (Exception e) {
                                System.err.println("❌ Error exporting CSV: " + e.getMessage());
                            }
                        }
                        break;

                    default:
                        System.out.println("⚠️ Invalid choice.");
                }
            }

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
