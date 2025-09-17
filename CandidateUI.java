package com.jobinterviewer.ui;

import com.jobinterviewer.model.Candidate;
import com.jobinterviewer.model.CandidateAnswer;
import com.jobinterviewer.model.Question;
import com.jobinterviewer.service.CandidateAnswerService;
import com.jobinterviewer.service.InterviewService;

import java.util.List;
import java.util.Scanner;

public class CandidateUI {
    private final InterviewService interviewService = new InterviewService();
    private final CandidateAnswerService answerService = new CandidateAnswerService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();

            interviewService.registerCandidate(name, email);
            Candidate candidate = new Candidate(0, name, email);

            List<Question> questions = interviewService.fetchQuestions();
            int score = 0;

            for (Question q : questions) {
                System.out.println("Q: " + q.getText());
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();

                boolean isCorrect = answer.equalsIgnoreCase(q.getAnswer());
                if (isCorrect) score++;

                CandidateAnswer ca = new CandidateAnswer(0, candidate.getId(), q.getId(), answer, isCorrect);
                answerService.saveAnswer(ca);
            }

            System.out.println("Interview completed!");
            System.out.println("Your Score: " + score + "/" + questions.size());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}